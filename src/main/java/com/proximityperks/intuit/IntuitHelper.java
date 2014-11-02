package com.proximityperks.intuit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*import com.intuit.ipp.aggcat.data.Transaction;
import com.intuit.ipp.aggcat.data.TransactionList;
import com.intuit.ipp.aggcat.exception.AggCatException;
import com.intuit.ipp.aggcat.service.AggCatService;*/

public class IntuitHelper {
	private static final Logger logger = LoggerFactory
			.getLogger(IntuitHelper.class);

	/*public TransactionList getAccountTransactions(AggCatService aggCatService)
			throws NumberFormatException, AggCatException {
		String startTxnDate = "2010" + "-" + "01" + "-" + "01";
		String endTxnDate = 2014 + "-" + "11" + "-" + "02";
		String accountId = "400051270480";
		TransactionList txnList = aggCatService.getAccountTransactions(
				Long.parseLong(accountId), startTxnDate, endTxnDate);
		if (txnList != null) {
			for (Transaction txn : txnList.getCreditCardTransactions()) {
				logger.info("Transaction id : {} amount :{} description :{}",
						txn.getId(), txn.getAmount(), txn.getMemo());
			}
		}
		return txnList;

	}*/
}
