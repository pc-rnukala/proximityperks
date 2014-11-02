package com.proximityperks.modo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.proximityperks.modo.delegate.CardRequest;
import com.proximityperks.modo.delegate.LocationVisitRequest;
import com.proximityperks.modo.delegate.ModoDelegate;
import com.proximityperks.modo.delegate.OfferRequest;
import com.proximityperks.modo.delegate.RegisterUserRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ModoServiceTest {

	@Autowired
	private ModoService modoService;

	@Autowired
	private ModoDelegate modoDelegate;

	@Test
	public void testGetToken() {
		String token = modoService.getModoToken();
		System.out.println("modoPaymentToken: " + token);
	}

	@Test
	public void testRegisterUser() {
		String phoneNumber = "5086379553";
		String firstName = "Ravi";
		String lastName = "Nukala";
		String middleName = "Kiran";
		String email = "nukala.ravi@gmail.com";
		String gender = "M";
		String dob = "2011-01-01";
		String password = "testModo";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			RegisterUserRequest registerUserRequest = new RegisterUserRequest(
					phoneNumber, firstName, lastName, middleName, email,
					gender, sdf.parse(dob), password);
			String accountId = modoDelegate.registerUser(registerUserRequest);
			System.out.println("accountId: " + accountId);
		} catch (Exception e) {
			System.out.println("Exception while processing registerUser: "
					+ e.getMessage());
		}

	}

	// @Test
	public void testAddRequest() {
		String accountId = "5bcc232664484fbfbdb3330bfb1df2ae";
		String cardNumber = "5141222233334445";
		String expiry = "0416";
		String zipCode = "94618";
		String cardSecurity = "333";
		try {
			CardRequest cardRequest = new CardRequest();
			cardRequest.setAccountId(accountId);
			cardRequest.setCardExpiry(expiry);
			cardRequest.setCardNumber(cardNumber);
			cardRequest.setSecurityCode(cardSecurity);
			cardRequest.setZipCode(zipCode);
			String cardId = modoDelegate.addCard(cardRequest);
			System.out.println("cardId: " + cardId);
		} catch (Exception e) {
			System.out.println("Exception while processing testAddRequest "
					+ e.getMessage());
		}
	}

	// @Test
	public void testGetOffers() {

		OfferRequest offerRequest = new OfferRequest();
		offerRequest.setAccountId("803c9228b3b243eb906530b7b9a10638");
		offerRequest.setShouldIncludeGiven(0);
		offerRequest.setMerchantId("ae6f5564ac8047d49cbe7ca144401b77");
		offerRequest.setLocationId("3c3944fbd48d4368a32f883d88c164b4");
		List<String> statusFilter = new ArrayList<>();
		statusFilter.add("live");
		statusFilter.add("used");
		offerRequest.setStatusFilter(new Gson().toJson(statusFilter));
		List<String> giverFilter = new ArrayList<>();
		giverFilter.add("user");
		giverFilter.add("merchant");
		offerRequest.setGiverFilter(new Gson().toJson(giverFilter));
		modoDelegate.getOffers(offerRequest);
	}

	// @Test
	public void testLocationVisit() {
		LocationVisitRequest locationVisitRequest = new LocationVisitRequest();
		locationVisitRequest.setAccountId("803c9228b3b243eb906530b7b9a10638");
		// locationVisitRequest.setLocationId("38613439616330303365623231316534");
		locationVisitRequest.setMerchantId("ae6f5564ac8047d49cbe7ca144401b77");
		JsonObject giftDetails = new JsonObject();
		giftDetails.addProperty("9b8e2602ec4947409cc342e98d7439e6", "0");
		JsonObject giftsArray = new JsonObject();
		giftsArray.add("offers", giftDetails);
		locationVisitRequest.setFundingSource(giftsArray.toString());
		modoDelegate.locationVisit(locationVisitRequest);
	}

}
