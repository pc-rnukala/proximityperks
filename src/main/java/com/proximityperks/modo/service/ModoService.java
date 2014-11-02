package com.proximityperks.modo.service;

import java.util.List;
import java.util.Map;

import com.proximityperks.data.User;
import com.proximityperks.data.UserPerk;
import com.proximityperks.modo.delegate.LocationVisitResponse;
import com.proximityperks.modo.delegate.MerchantLocation;

public interface ModoService {

	public String getModoToken();

	public boolean redeemPerk(User user, UserPerk userPerk,
			Double checkoutAmount, String checkoutCode);

	public LocationVisitResponse visitLocation(User user, UserPerk userPerk);

	public Map<String, UserPerk> getOffers(User user, String merchantId,
			String locationId);

	public List<MerchantLocation> getMerchantLocations(User user,
			double longitude, double latitude);
}
