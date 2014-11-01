package com.proximityperks.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.data.User;
import com.proximityperks.data.impl.UserImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration
@Transactional(value = "proximityPerksTran")
public class UsersDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testGetUsers() {
		createUser();
		List<User> users = userDao.getUsers();
		Assert.assertNotNull(users);

	}

	public User createUser() {
		User user = new UserImpl();
		user.setCreatedDate(new DateTime().toDate());
		user.setModoAccountId("testId");
		user.setPassword("testPassword");
		user.setPhoneNumber("2348479489");
		user.setUpdatedDate(new DateTime().toDate());
		user.setUserGuid("3432uerwerw");
		user.setUserName("testUserId@personalcapital.com");
		User createdUser = userDao.saveOrUpdate(user);
		return createdUser;
	}

	@Test
	public void testCreateUser() {
		User createdUser = createUser();
		Assert.assertNotNull(createdUser);
		Assert.assertNotNull(createdUser.getId());
	}

	@Test
	public void testUpdateUser() {
		User createdUser = createUser();
		Assert.assertNotNull(createdUser);
		Assert.assertNotNull(createdUser.getId());
		createdUser.setPhoneNumber("456378979");
		User updatedUser = userDao.saveOrUpdate(createdUser);
		Assert.assertNotNull(updatedUser);
		Assert.assertTrue(createdUser.getPhoneNumber().equalsIgnoreCase(
				"456378979"));
	}

	@Test
	public void testDeleteUser() {
		User createdUser = createUser();
		Assert.assertNotNull(createdUser);
		Assert.assertNotNull(createdUser.getId());
		boolean deleteStatus = userDao.deleteUser(createdUser);
		Assert.assertTrue(deleteStatus);
	}
}
