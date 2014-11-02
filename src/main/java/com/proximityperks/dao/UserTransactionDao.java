package com.proximityperks.dao;

import java.util.List;

import com.proximityperks.data.Transaction;

public interface UserTransactionDao {
	public List<Transaction> getUserTransactions(List<Long> userAccountIds);
}
