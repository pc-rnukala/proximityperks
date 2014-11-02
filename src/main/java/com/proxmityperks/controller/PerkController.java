package com.proxmityperks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proximityperks.dao.UserDao;
import com.proximityperks.dao.UserPerkDao;
import com.proximityperks.data.User;
import com.proximityperks.data.UserPerk;
import com.proximityperks.data.impl.UserPerkStatus;
import com.proximityperks.model.ProxmityPerksJsonModel;
import com.proximityperks.modo.delegate.LocationVisitResponse;
import com.proximityperks.modo.delegate.MerchantLocation;
import com.proximityperks.modo.service.ModoService;

@Controller
public class PerkController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserPerkDao userPerkDao;

	@Autowired
	private ModoService modoService;

	@RequestMapping(value = APIRequestMappings.GET_PERKS, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel getPerks(
			@RequestParam(value = "userGuid", required = true) String userGuid,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longitude", required = true) Double longitude) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		List<String> errorList = new ArrayList<String>();
		User user = userDao.getUserByGuid(userGuid);
		if (user != null) {
			header.put("status", true);
			// 1. for the given latitude and longitude get the list of merchants
			// and location id
			List<MerchantLocation> merchantLocations = modoService
					.getMerchantLocations(longitude, latitude);

			// 2. iterate through the list of merchants and location and get the
			// offers
			List<UserPerk> allPerksForUser = new ArrayList<>();
			Map<String, MerchantLocation> merchantLocationMap = new HashMap<>();
			for (MerchantLocation merchantLocation : merchantLocations) {
				if (merchantLocation == null) {
					continue;
				}
				if (merchantLocation.getMerchantId() == null) {
					continue;
				}
				if (merchantLocation.getLocationId() == null) {
					continue;
				}
				List<UserPerk> userPerks = modoService.getOffers(user,
						merchantLocation.getMerchantId(),
						merchantLocation.getLocationId());
				merchantLocationMap.put(merchantLocation.getMerchantId(),
						merchantLocation);
				allPerksForUser.addAll(userPerks);
			}
			// 3. persist the offers in the database and return back to the UI
			if (allPerksForUser != null && allPerksForUser.isEmpty() == false) {
				// remove all the old perks for the users
				try {
					List<UserPerk> existingUserPerks = userPerkDao
							.getUserPerks(user);
					if (existingUserPerks != null) {
						for (UserPerk existinUserPerk : existingUserPerks) {
							userPerkDao.deleteUserPerk(existinUserPerk);
						}
					}
				} catch (Exception e) {
					logger.info("Exception while deleting existing offers: "
							+ e.getMessage(), e);
				}

				for (UserPerk userPerk : allPerksForUser) {
					if (userPerk == null) {
						continue;
					}
					try {
						userPerkDao.saveOrUpdate(userPerk);
					} catch (Exception e) {
						logger.error(
								"Exceptoin while saving or updating the Perks "
										+ e.getMessage(), e);
					}
				}
			}
			// 4. get all the offers from database and jsonize and return it to
			// user
			List<UserPerk> perksToReturn = userPerkDao.getUserPerks(user,
					UserPerkStatus.ACTIVE);
			List<PerkJsonizer> perkJsonizers = new ArrayList<>();
			for (UserPerk userPerk : perksToReturn) {
				if (userPerk == null) {
					continue;
				}
				PerkJsonizer perkJsonizer = new PerkJsonizer();
				perkJsonizer.setMerchantId(userPerk.getMerchantId());
				MerchantLocation merchantLocation = merchantLocationMap
						.get(userPerk.getMerchantId()) != null ? merchantLocationMap
						.get(userPerk.getMerchantId()) : null;
				if (merchantLocation == null) {
					continue;
				}
				perkJsonizer
						.setMerchantName(merchantLocation.getMerchantName());
				perkJsonizer.setLatitude(merchantLocation.getLatitude());
				perkJsonizer.setLongitude(merchantLocation.getLongitude());
				perkJsonizer.setPerkId(userPerk.getId() + "");
				String redemptionDetails = userPerk.getRedemptionDetails();
				Gson gson = new Gson();
				JsonObject redemptionJson = gson.fromJson(redemptionDetails,
						JsonObject.class);
				perkJsonizer
						.setDescription(redemptionJson.get("description") != null ? redemptionJson
								.get("description").getAsString() : null);
				perkJsonizers.add(perkJsonizer);
			}
			data.put("perks", perkJsonizers);
			header.put("userGuid", user.getUserGuid());
		} else {
			errorList.add("Invalid user guid");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}

	@RequestMapping(value = APIRequestMappings.REDEEM_PERKS, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel redeemPerks(
			@RequestParam(value = "userGuid", required = true) String userGuid,
			@RequestParam(value = "perkId", required = true) String userPerkId) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		List<String> errorList = new ArrayList<String>();
		User user = userDao.getUserByGuid(userGuid);
		if (user != null) {
			header.put("status", true);
			UserPerk userPerk = userPerkDao.getUserPerkById(Long
					.valueOf(userPerkId));
			String redemptionDetails = userPerk.getRedemptionDetails();
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(redemptionDetails
					.toString());
			String checkoutCode = o.get("checkout_code") != null ? o.get(
					"checkout_code").getAsString() : null;
			Double checkoutAmount = Double.valueOf("0.00");
			boolean redeemStatus = modoService.redeemPerk(user, userPerk,
					checkoutAmount, checkoutCode);
			header.put("userGuid", user.getUserGuid());
			header.put("status", redeemStatus);
		} else {
			errorList.add("Invalid user guid");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}

	@RequestMapping(value = APIRequestMappings.VISIT_PERK_LOCATION, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel visitPerkLocation(
			@RequestParam(value = "userGuid", required = true) String userGuid,
			@RequestParam(value = "perkId", required = true) String userPerkId) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		List<String> errorList = new ArrayList<String>();
		User user = userDao.getUserByGuid(userGuid);
		if (user != null) {
			header.put("status", true);
			UserPerk userPerk = userPerkDao.getUserPerkById(Long
					.valueOf(userPerkId));
			LocationVisitResponse locationVisitResposne = modoService
					.visitLocation(user, userPerk);
			if (locationVisitResposne != null) {
				data.put("modoCheckoutCode",
						locationVisitResposne.getCheckoutCode());
				data.put("barCode", locationVisitResposne.getBarcodeImageData());
			}
			header.put("userGuid", user.getUserGuid());
			header.put("status", true);

		} else {
			errorList.add("Invalid user guid");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}

}

class PerkJsonizer {
	private String merchantId;
	private String merchantName;
	private double latitude;
	private double longitude;
	private String description;
	private String perkId;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerkId() {
		return perkId;
	}

	public void setPerkId(String perkId) {
		this.perkId = perkId;
	}

}
