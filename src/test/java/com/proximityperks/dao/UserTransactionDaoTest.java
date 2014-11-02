package com.proximityperks.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.data.User;
import com.proximityperks.modo.delegate.MerchantLocation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration
@Transactional(value = "proximityPerksTran")
public class UserTransactionDaoTest {

	@Autowired
	private UserTransactionDao userTransactionDao;

	@Autowired
	private UserDao userDao;

	@Test
	public void testGetUserTransactions() {
		User user = userDao.getUser("user1@personalcapital.com");
		Assert.assertNotNull(user);
		List<MerchantLocation> merchangeLocations = userTransactionDao
				.getMerchantLocations(user);
		Assert.assertNotNull(merchangeLocations);

	}

}
