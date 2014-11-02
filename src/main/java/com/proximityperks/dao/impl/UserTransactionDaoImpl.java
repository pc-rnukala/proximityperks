package com.proximityperks.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.dao.UserTransactionDao;

public class UserTransactionDaoImpl extends DaoImpl implements
		UserTransactionDao {

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserTransaction> getUserTransactions(List<Long> userAccountIds) {
		if (userAccountIds == null || userAccountIds.isEmpty()) {
			return null;
		}
		try {
			final String queryString = "select model from TransactionImpl model where model.userAccountId in (:userAccountIds)";
			Query query = em.createQuery(queryString);
			query.setParameter("userAccountIds", userAccountIds);
			List<UserTransaction> result = query.getResultList();
			if (result != null && result.size() > 0) {
				return result;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			logger.error("getUserTransactions", re);
			throw re;
		}
	}
}
