package com.proximityperks.modo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.proximityperks.dao.UserPerkDao;
import com.proximityperks.data.User;
import com.proximityperks.data.UserPerk;
import com.proximityperks.data.impl.UserPerkImpl;
import com.proximityperks.data.impl.UserPerkStatus;
import com.proximityperks.modo.delegate.LocationCheckoutRequest;
import com.proximityperks.modo.delegate.LocationVisitRequest;
import com.proximityperks.modo.delegate.LocationVisitResponse;
import com.proximityperks.modo.delegate.MerchantLocation;
import com.proximityperks.modo.delegate.ModoDelegate;
import com.proximityperks.modo.delegate.OfferRequest;
import com.proximityperks.modo.delegate.UserCheckOutRequest;
import com.proximityperks.modo.service.ModoService;

public class ModoServiceImpl implements ModoService {

	private static Logger logger = LoggerFactory
			.getLogger(ModoServiceImpl.class);

	@Autowired
	private ModoDelegate modoDelegate;

	@Autowired
	private UserPerkDao userPerkDao;

	/**
	 * @return
	 */
	public String getModoToken() {
		return modoDelegate.getModoToken();
	}

	/**
	 * 
	 * vist Location by User and userPerk
	 */
	public LocationVisitResponse visitLocation(User user, UserPerk userPerk) {
		if (user == null) {
			return null;
		}
		if (userPerk == null) {
			return null;
		}
		LocationVisitResponse locationVisitResponse = null;
		try {
			LocationVisitRequest locationVisitRequest = new LocationVisitRequest();
			locationVisitRequest.setAccountId(user.getModoAccountId());
			// locationVisitRequest.setLocationId("38613439616330303365623231316534");
			locationVisitRequest.setMerchantId(userPerk.getMerchantId());
			JsonObject giftDetails = new JsonObject();
			giftDetails.addProperty(userPerk.getModoPerkId(), "0");
			JsonObject giftsArray = new JsonObject();
			giftsArray.add("offers", giftDetails);
			locationVisitRequest.setFundingSource(giftsArray.toString());
			locationVisitResponse = modoDelegate
					.locationVisit(locationVisitRequest);
		} catch (Exception e) {
			logger.error(
					"Exception while processing visit loction: "
							+ e.getMessage(), e);
		}
		return locationVisitResponse;
	}

	/**
	 * This method is used to redeemPerk
	 * 
	 * @param user
	 * @param checkoutAmount
	 * @param checkoutCode
	 * @return
	 */
	public boolean redeemPerk(User user, UserPerk userPerk,
			Double checkoutAmount, String checkoutCode) {
		// location Checkout
		LocationCheckoutRequest locationCheckoutRequest = new LocationCheckoutRequest(
				user.getModoAccountId(), checkoutCode, checkoutAmount);
		boolean isLocationCheckoutStatus = modoDelegate
				.locationCheckout(locationCheckoutRequest);
		/*
		 * Put the request to sleep for 5 seconds atleast is the suggestion from
		 * Modo
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			logger.error("Exception while interrupting the sleep: "
					+ ie.getMessage());
		}
		// user Checkout
		UserCheckOutRequest userCheckoutRequest = new UserCheckOutRequest();
		boolean isUserCheckoutStatus = modoDelegate
				.userCheckout(userCheckoutRequest);
		try {
			if (isLocationCheckoutStatus && isUserCheckoutStatus) {
				UserPerk userPerkDB = userPerkDao.getUserPerkById(userPerk
						.getId());
				userPerkDB.setPerkStatus(UserPerkStatus.USED);
				userPerkDao.saveOrUpdate(userPerkDB);
			}
		} catch (Exception e) {
			logger.error("Exception while updating the perk Status as used: "
					+ e.getMessage(), e);
		}

		return isLocationCheckoutStatus && isUserCheckoutStatus;
	}

	/**
	 * @param longitude
	 * @param latitude
	 * @return
	 */
	public List<MerchantLocation> getMerchantLocations(double longitude,
			double latitude) {
		List<MerchantLocation> merchantLocations = modoDelegate.getMerchants(
				longitude, latitude);
		merchantLocations = new ArrayList<>();
		MerchantLocation merchantLocation = new MerchantLocation();
		merchantLocation.setMerchantId("8161fa6cd0c24c6ab9606252713ab571");
		merchantLocation.setMerchantName("Starbucks Aria");
		merchantLocation.setLocationId("451427e2ec874abcaa13200c1443ab8b");
		merchantLocation.setLatitude(36.161578);
		merchantLocation.setLongitude(-115.17324);
		merchantLocations.add(merchantLocation);
		merchantLocation = new MerchantLocation();
		merchantLocation.setMerchantId("3da28d76b4af44a293baea703644643b");
		merchantLocation.setMerchantName("Gucci");
		merchantLocation.setLocationId("920e8565acf649aea98dc1ea848d60ca");
		merchantLocation.setLatitude(-115.17369);
		merchantLocation.setLongitude(36.107159);
		merchantLocations.add(merchantLocation);
		return merchantLocations;
	}

	/**
	 * @param user
	 * @param merchantId
	 * @param locationId
	 */
	public List<UserPerk> getOffers(User user, String merchantId,
			String locationId) {
		OfferRequest offerRequest = new OfferRequest();
		offerRequest.setAccountId(user.getModoAccountId());
		offerRequest.setShouldIncludeGiven(0);
		offerRequest.setMerchantId(merchantId);
		offerRequest.setLocationId(locationId);
		List<String> statusFilter = new ArrayList<>();
		statusFilter.add("live");
		statusFilter.add("used");
		offerRequest.setStatusFilter(new Gson().toJson(statusFilter));
		List<String> giverFilter = new ArrayList<>();
		giverFilter.add("user");
		giverFilter.add("merchant");
		offerRequest.setGiverFilter(new Gson().toJson(giverFilter));
		JsonObject responseData = modoDelegate.getOffers(offerRequest);
		List<UserPerk> userPerks = parseOffersResponse(user, responseData);
		return userPerks;
	}

	private List<UserPerk> parseOffersResponse(User user,
			JsonObject responseData) {
		JsonArray offersArray = responseData
				.getAsJsonArray(ModoDelegate.OFFERS);
		List<UserPerk> userPerks = new ArrayList<>();
		if (offersArray == null) {
			return userPerks;
		}
		for (JsonElement jsonElement : offersArray) {
			if (jsonElement == null) {
				continue;
			}
			JsonObject offerJson = jsonElement.getAsJsonObject();
			if (offerJson == null) {
				continue;
			}
			String locationId = offerJson.get("location_id").getAsString();
			String merchantId = offerJson.get("merchant_id").getAsString();
			String modoPerkId = offerJson.get("invite_id").getAsString();
			Double amount = offerJson.get("invite_amount").getAsDouble();
			String description = offerJson.get("user_message").getAsString();
			String dateGiven = offerJson.get("date_given").getAsString();
			String dateExpiry = offerJson.get("date_expiry").getAsString();
			UserPerk userPerk = new UserPerkImpl();
			userPerk.setLocationId(locationId);
			userPerk.setMerchantId(merchantId);
			userPerk.setModoPerkId(modoPerkId);
			userPerk.setPerkStatus(UserPerkStatus.ACTIVE);
			userPerk.setUserId(user.getId());
			userPerk.setCreatedDate(DateTime.now().toDate());
			userPerk.setUpdatedDate(DateTime.now().toDate());
			JsonObject redemptionDetails = new JsonObject();
			redemptionDetails.addProperty("amount", String.valueOf(amount));
			redemptionDetails.addProperty("description", description);
			redemptionDetails.addProperty("dateGiven", dateGiven);
			redemptionDetails.addProperty("dateExpiry", dateExpiry);
			userPerk.setRedemptionDetails(redemptionDetails.toString());
			userPerks.add(userPerk);
		}
		return userPerks;
	}
}
