package com.proximityperks.modo.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ModoDelegate {

	public static Logger logger = LoggerFactory.getLogger(ModoDelegate.class);
	public static final String CONSUMER_KEY_VALUE = "8598026cc55747987a206d5e22bfca8e";
	public static final String SECRET_KEY_VALUE = "8da00a1586cf00b781b1abb9c2d6f62dd4efbc41c0a4cb64069c105b99d5ea31";
	public static final String BASE_MODO_API = "https://api.sbx.gomo.do/YiiModo/api_v2/";
	public static final String REGISTER_USER_API = "people/register";
	public static final String ADD_CARD_API = "card/add";
	public static final String OFFER_LOOKUP_API = "offer/lookup";
	public static final String MERCHANT_API = "merchant/list";
	public static final String GIFT_SEND_API = "gift/send";
	public static final String LOCATION_VIST_API = "location/visit";
	public static final String DELETE_GIFT_API = "gift/delete";
	public static final String LOCATION_FIND_API = "location/find";
	public static final String LOCATION_CHECKOUT_API = "location/checkout";
	public static final String USER_CHECKOUT_API = "location/user_checkout";
	public static final String TOKEN_API = "token";
	public static final String CREDENTIALS = "credentials";
	public static final String RESPONSE_DATA = "response_data";
	public static final String OFFERS = "offers";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String ACCOUNT_ID = "account_id";
	public static final String CHECKOUT_CODE = "checkout_code";
	public static final String BAR_CODE_IMAGE_STRING = "barcode_image_data";
	public static final String CHECKOUT_AMOUNT = "checkout_amount";
	public static final String PHONE = "phone";
	public static final String FNAME = "fname";
	public static final String LNAME = "lname";
	public static final String MNAME = "mname";
	public static final String EMAIL = "email";
	public static final String GENDER = "gender";
	public static final String DOB = "dob";
	public static final String PASSWORD = "password";
	public static final String SHOULD_SEND_PASSWORD = "should_send_password";
	public static final String SHOULD_SEND_MODO_DESCRIPT = "should_send_modo_descript";
	public static final String IS_MODO_TERMS_AGREE = "is_modo_terms_agree";
	public static final String CONSUMER_KEY = "consumer_key";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String CARD_NUMBER = "card_number";
	public static final String EXPIRY = "expiry";
	public static final String ZIP_CODE = "zip_code";
	public static final String CARD_SECURITY = "card_security";
	public static final String CARD_ID = "card_id";

	/**
	 * This method is used the get latest modo token
	 */
	public String getModoToken() {

		String freshToken = "";
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String rawCredentials = CONSUMER_KEY_VALUE + ":" + SECRET_KEY_VALUE;
			String credentialsEncoded = Base64
					.encodeBase64String(rawCredentials.getBytes());
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + TOKEN_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CREDENTIALS,
					credentialsEncoded));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			JsonObject responseData = o.getAsJsonObject(RESPONSE_DATA);
			if (responseData != null) {
				JsonElement element = responseData.get(ACCESS_TOKEN);
				freshToken = element != null ? element.getAsString() : null;
			}
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return freshToken;

	}

	/**
	 * This method is used to registerUser with Mode and returns the
	 * modoAccountId
	 * 
	 * @param registerUserRequest
	 */
	public String registerUser(RegisterUserRequest registerUserRequest) {

		String freshToken = "";
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + REGISTER_USER_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(PHONE,
					registerUserRequest.getPhoneNumber()));
			nameValuePairs.add(new BasicNameValuePair(FNAME,
					registerUserRequest.getFirstName()));
			nameValuePairs.add(new BasicNameValuePair(LNAME,
					registerUserRequest.getLastName()));
			nameValuePairs.add(new BasicNameValuePair(MNAME,
					registerUserRequest.getMiddleName()));
			nameValuePairs.add(new BasicNameValuePair(EMAIL,
					registerUserRequest.getEmail()));
			nameValuePairs.add(new BasicNameValuePair(GENDER,
					registerUserRequest.getGender()));
			SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
			String birthDate = sdf.format(registerUserRequest.getDob());
			nameValuePairs.add(new BasicNameValuePair(DOB, birthDate));
			nameValuePairs.add(new BasicNameValuePair(PASSWORD,
					registerUserRequest.getPassword()));
			nameValuePairs.add(new BasicNameValuePair(SHOULD_SEND_PASSWORD,
					String.valueOf(1)));
			nameValuePairs.add(new BasicNameValuePair(
					SHOULD_SEND_MODO_DESCRIPT, String.valueOf(0)));
			nameValuePairs.add(new BasicNameValuePair(IS_MODO_TERMS_AGREE,
					String.valueOf(1)));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			JsonObject responseData = o.getAsJsonObject(RESPONSE_DATA);
			if (responseData != null) {
				JsonElement element = responseData.get(ACCOUNT_ID);
				freshToken = element != null ? element.getAsString() : null;
			}
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return freshToken;

	}

	/**
	 * This method is used to addCard
	 * 
	 * @param cardRequest
	 * @return
	 * @throws Exception
	 */
	public String addCard(CardRequest cardRequest) throws Exception {
		String freshToken = "";
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + ADD_CARD_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(ACCOUNT_ID, cardRequest
					.getAccountId()));
			nameValuePairs.add(new BasicNameValuePair(CARD_NUMBER, cardRequest
					.getCardNumber()));
			nameValuePairs.add(new BasicNameValuePair(EXPIRY, cardRequest
					.getCardExpiry()));
			nameValuePairs.add(new BasicNameValuePair(ZIP_CODE, cardRequest
					.getZipCode()));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			JsonObject responseData = o.getAsJsonObject(RESPONSE_DATA);
			if (responseData != null) {
				JsonElement element = responseData.get(CARD_ID);
				freshToken = element != null ? element.getAsString() : null;
			}
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} catch (Exception e) {
			logger.error("Exception while processing addCard Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return freshToken;

	}

	/**
	 * This is to fetch the list of Offers
	 * 
	 * @ TODO: see the actual response and set the response objects accordingly
	 * 
	 * @param offerRequest
	 */
	public JsonObject getOffers(OfferRequest offerRequest) {

		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		JsonObject responseData = null;
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + OFFER_LOOKUP_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(OfferRequest.ACCOUNT_ID,
					offerRequest.getAccountId()));
			nameValuePairs.add(new BasicNameValuePair(OfferRequest.MERCHANT_ID,
					offerRequest.getMerchantId()));
			nameValuePairs.add(new BasicNameValuePair(OfferRequest.LOCATION_ID,
					offerRequest.getLocationId()));
			nameValuePairs.add(new BasicNameValuePair(
					OfferRequest.STATUS_FILTER, offerRequest.getStatusFilter()
							.toString()));
			nameValuePairs.add(new BasicNameValuePair(
					OfferRequest.GIVER_FILTER, offerRequest.getGiverFilter()
							.toString()));
			nameValuePairs.add(new BasicNameValuePair(
					OfferRequest.SHOULD_INCLUDE_GIVEN, String
							.valueOf(offerRequest.getShouldIncludeGiven())));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			responseData = o.getAsJsonObject(RESPONSE_DATA);
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} catch (Exception e) {
			logger.error("Exception while processing addCard Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return responseData;
	}

	/**
	 * Location visit api
	 * 
	 * @param locationVisitRequest
	 */
	public LocationVisitResponse locationVisit(
			LocationVisitRequest locationVisitRequest) {
		LocationVisitResponse locationVisitResponse = new LocationVisitResponse();
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		String checkoutCode = "";
		String barcodeImageData = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + LOCATION_VIST_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(
					LocationVisitRequest.MERCHANT_ID, locationVisitRequest
							.getMerchantId()));
			nameValuePairs.add(new BasicNameValuePair(
					LocationVisitRequest.ACCOUNT_ID, locationVisitRequest
							.getAccountId()));
			nameValuePairs.add(new BasicNameValuePair(
					LocationVisitRequest.LOCATION_ID, locationVisitRequest
							.getLocationId()));
			nameValuePairs.add(new BasicNameValuePair(
					LocationVisitRequest.FUNDING_SOURCES, locationVisitRequest
							.getFundingSource()));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			JsonObject responseData = o.getAsJsonObject(RESPONSE_DATA);
			if (responseData != null) {
				JsonElement checkoutCodeResponse = responseData
						.get(CHECKOUT_CODE);
				checkoutCode = checkoutCodeResponse != null ? checkoutCodeResponse
						.getAsString() : null;
				locationVisitResponse.setCheckoutCode(checkoutCode);
				JsonElement barCodeImageResponse = responseData
						.get(BAR_CODE_IMAGE_STRING);
				barcodeImageData = barCodeImageResponse != null ? barCodeImageResponse
						.getAsString() : null;
				locationVisitResponse.setBarcodeImageData(barcodeImageData);
			}
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} catch (Exception e) {
			logger.error("Exception while processing addCard Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}

		return locationVisitResponse;

	}

	public void locationFind(double latitude, double longitude) {

		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + LOCATION_FIND_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair("method", "GPS_EXTENTS"));
			nameValuePairs.add(new BasicNameValuePair("latitude", String
					.valueOf(latitude)));
			nameValuePairs.add(new BasicNameValuePair("longitude", String
					.valueOf(longitude)));
			nameValuePairs.add(new BasicNameValuePair("east_west_extent",
					"10000"));
			nameValuePairs.add(new BasicNameValuePair("north_south_extent",
					"10000"));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}

			JsonObject responseData = o.getAsJsonObject(RESPONSE_DATA);
			if (responseData != null) {
				JsonArray locations = responseData.getAsJsonArray("locations");
				for (JsonElement element : locations) {
					JsonObject locationJson = element.getAsJsonObject();

				}
			}
		} catch (IOException e) {
			logger.error("Exception while deleteGift: " + e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Exception while processing deleteGift Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}

	}

	/**
	 * Returns true if everything is fine otherwise returns false
	 * 
	 * @param locationCheckoutRequest
	 * @return
	 */
	public boolean locationCheckout(
			LocationCheckoutRequest locationCheckoutRequest) {

		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + LOCATION_CHECKOUT_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(ACCOUNT_ID,
					locationCheckoutRequest.getAccountId()));
			nameValuePairs.add(new BasicNameValuePair(CHECKOUT_CODE,
					locationCheckoutRequest.getCheckoutCode()));
			nameValuePairs.add(new BasicNameValuePair(CHECKOUT_AMOUNT,
					locationCheckoutRequest.getCheckoutAmount()));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			return true;

		} catch (IOException e) {
			logger.error("Exception while deleteGift: " + e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Exception while processing deleteGift Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return false;
	}

	/**
	 * This method returns false if everything is successful
	 * 
	 * @param userCheckoutRequest
	 * @return
	 */
	public boolean userCheckout(UserCheckOutRequest userCheckoutRequest) {

		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + USER_CHECKOUT_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			nameValuePairs.add(new BasicNameValuePair(ACCOUNT_ID,
					userCheckoutRequest.getAccountId()));
			nameValuePairs.add(new BasicNameValuePair(CHECKOUT_CODE,
					userCheckoutRequest.getCheckoutCode()));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			return true;

		} catch (IOException e) {
			logger.error("Exception while deleteGift: " + e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Exception while processing deleteGift Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return false;

	}

	/**
	 * This method is used fetch the merchant locations for the given longitude
	 * and latitude
	 * 
	 * @param longitude
	 * @param latitude
	 * @return
	 */
	public List<MerchantLocation> getMerchants(double longitude, double latitude) {

		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		String line = "";
		JsonArray responseDataArray = null;
		List<MerchantLocation> merchantLocations = new ArrayList<>();
		StringBuilder responseString = new StringBuilder();
		try {
			// get the http client
			client = HttpClients.createDefault();
			String accessToken = getModoToken();
			// construct modo api
			HttpPost post = new HttpPost(BASE_MODO_API + MERCHANT_API);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair(CONSUMER_KEY,
					CONSUMER_KEY_VALUE));
			nameValuePairs
					.add(new BasicNameValuePair(ACCESS_TOKEN, accessToken));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			// Execute the modo post
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			/*
			 * Read the line by line response from modo
			 */
			while ((line = rd.readLine()) != null) {
				responseString.append(line);
			}
			/*
			 * Parse the api response to fetch the access token
			 */
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(responseString.toString());
			String statusCode = o.get("status_code") != null ? o.get(
					"status_code").getAsString() : null;
			logger.info("Status Code: " + statusCode);
			if (statusCode.equals("0") == false) {
				throw new Exception();
			}
			responseDataArray = o.getAsJsonArray(RESPONSE_DATA);
			for (JsonElement jsonElement : responseDataArray) {
				if (jsonElement == null) {
					continue;
				}
				JsonObject merchantElement = jsonElement.getAsJsonObject();
				if (merchantElement == null) {
					continue;
				}
				String merchantName = jsonElement.getAsJsonObject().get(
						"merchant_name") != null ? jsonElement
						.getAsJsonObject().get("merchant_name").getAsString()
						: null;
				String merchantId = merchantElement.get("merchant_id") != null ? merchantElement
						.get("merchant_id").getAsString() : null;
				if (merchantElement != null
						&& merchantElement.get("locations") != null) {
					JsonArray locationsArray = merchantElement
							.getAsJsonArray("locations");
					if (locationsArray != null) {
						for (JsonElement locationElement : locationsArray) {
							if (locationElement == null) {
								continue;
							}
							JsonObject locationJson = locationElement
									.getAsJsonObject();
							if (locationJson == null) {
								continue;
							}
							Double receivedLatitude = locationJson
									.get("latitude") != null ? locationJson
									.get("latitude").getAsDouble() : null;
							Double receivedLongitude = locationJson
									.get("longitude") != null ? locationJson
									.get("longitude").getAsDouble() : null;
							if (receivedLatitude == null
									|| receivedLongitude == null) {
								continue;
							}
							String locationId = locationJson.get("locationId") != null ? locationJson
									.get("locationId").getAsString() : null;

							if (receivedLatitude == latitude
									&& receivedLongitude == longitude) {
								MerchantLocation merchantLocation = new MerchantLocation();
								merchantLocation.setLocationId(locationId);
								merchantLocation.setMerchantId(merchantId);
								merchantLocation.setMerchantName(merchantName);
								merchantLocations.add(merchantLocation);
							}
						}
					}
				}
			}
		} catch (IOException e) {
			logger.error(
					"Exception while fetching the getToken: " + e.getMessage(),
					e);
		} catch (Exception e) {
			logger.error("Exception while processing addCard Request: "
					+ e.getMessage());
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					logger.error(
							"Exception while closing the response: "
									+ e.getMessage(), e);
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (Exception e) {
					logger.error("Exception while closing the http Client: "
							+ e.getMessage(), e);
				}
			}

		}
		return merchantLocations;

	}
}
