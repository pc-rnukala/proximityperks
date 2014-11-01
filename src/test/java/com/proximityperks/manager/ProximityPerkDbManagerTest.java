package com.proximityperks.manager;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ProximityPerkDbManagerTest {
	@Autowired
	ProximityPerkDbManager proximityPerkDbManager;

	@Test
	public void testDbConnection() {
		boolean status = false;
		try {
			Connection connection = proximityPerkDbManager.getConnection();
			status = connection != null ? true : false;
			connection.close();
		} catch (Exception e) {
			status = false;
		}
		assertTrue("Db status failed", status);
	}
}
