package com.proximityperks.intuit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.intuit.ipp.aggcat.core.Context;
import com.intuit.ipp.aggcat.core.OAuthAuthorizer;
import com.intuit.ipp.aggcat.exception.AggCatException;
import com.intuit.ipp.aggcat.service.AggCatService;

public class IntuitContext {
	private static final Logger logger = LoggerFactory
			.getLogger(IntuitContext.class);

	private String oauthConsumerKey;
	private String oauthConsumerSecret;
	private String samlProviderId;

	public String getOauthConsumerKey() {
		return oauthConsumerKey;
	}

	public void setOauthConsumerKey(String oauthConsumerKey) {
		this.oauthConsumerKey = oauthConsumerKey;
	}

	public String getOauthConsumerSecret() {
		return oauthConsumerSecret;
	}

	public void setOauthConsumerSecret(String oauthConsumerSecret) {
		this.oauthConsumerSecret = oauthConsumerSecret;
	}

	public String getSamlProviderId() {
		return samlProviderId;
	}

	public void setSamlProviderId(String samlProviderId) {
		this.samlProviderId = samlProviderId;
	}

	/**
	 * This method will first create OAuthAuthorizer instance using consumerkey,
	 * consumersecret samlproviderid and user id. This OAuthAuthorizer object
	 * will be used to create the context object, which in turn is used to
	 * create the AggCatService instance.
	 * 
	 * @param userId
	 * @return AggCatService
	 * @throws AggCatException
	 */
	public AggCatService getAggCatService(String userId) throws AggCatException {
		AggCatService service = null;
		try {
			/**
			 * Creating the OAuthAuthorizer instance using
			 * OAUTH_CONSUMER_KEY,OAUTH_CONSUMER_SECRET,SAML_PROVIDER_ID and
			 * userId. In this step, the oAuth accesstoken,accesstokensecret are
			 * generated and the OAuthAuthorizer instance is ready to use for
			 * generating the context instance
			 */
			OAuthAuthorizer oauthAuthorizer = new OAuthAuthorizer(
					getOauthConsumerKey(), getOauthConsumerSecret(),
					getSamlProviderId(), userId);

			/**
			 * Using the OAuthAuthorizer instance to create the context.
			 */
			Context context = new Context(oauthAuthorizer);
			/**
			 * Using the context instance to create the AggCatService.
			 */
			service = new AggCatService(context);

		} catch (AggCatException ex) {
			logger.error("AggCatException occured", ex);
			throw new AggCatException(
					"Exception while generating OAuth tokens. Please check whether the configured keys and cert files are valid.",
					ex);
		}
		return service;

	}
}
