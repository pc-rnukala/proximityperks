package com.proximityperks.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.proxmityperks.controller.APIRequestMappings;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestLoginController {
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testLoginUser() throws Exception {
		String userName = "testUserId1@personalcapital.com";
		String password = "password";
		ResultActions resultActions = mockMvc.perform(post(
				APIRequestMappings.LOGIN_USER).param("userName", userName)
				.param("password", password));
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(APPLICATION_JSON_UTF8));
		MvcResult result = resultActions.andReturn();
		MockHttpServletResponse response = result.getResponse();
		String resultStr = response.getContentAsString();
		Assert.assertNotNull(resultStr);
	}

	@Test
	public void testCreateUser() throws Exception {
		String userName = "testuser" + UUID.randomUUID().toString()
				+ "@personalcapital.com";
		String password = "password";
		String phoneNumber="4154206686";
		ResultActions resultActions = mockMvc.perform(post(
				APIRequestMappings.CREATE_USER).param("userName", userName)
				.param("password", password).param("phoneNumber", phoneNumber));
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(content().contentType(APPLICATION_JSON_UTF8));
		MvcResult result = resultActions.andReturn();
		MockHttpServletResponse response = result.getResponse();
		String resultStr = response.getContentAsString();
		Assert.assertNotNull(resultStr);
	}

}
