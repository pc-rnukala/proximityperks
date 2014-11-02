package com.proximityperks.intuit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intuit.ipp.aggcat.data.TransactionList;
import com.intuit.ipp.aggcat.service.AggCatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class IntuitContextTest {

	@Autowired
	private IntuitContext intuitContext;

	@Test
	public void testGetAggCatService() throws Exception {
		String userId = "user";
		AggCatService aggCatService = intuitContext.getAggCatService(userId);
		Assert.assertNotNull(aggCatService);
	}

	@Test
	public void testgetAccountTransactions() throws Exception {
		String userId = "user";
		AggCatService aggCatService = intuitContext.getAggCatService(userId);
		Assert.assertNotNull(aggCatService);
		IntuitHelper helper = new IntuitHelper();
		TransactionList txnList = helper.getAccountTransactions(aggCatService);
		Assert.assertNotNull(txnList);
	}
}
