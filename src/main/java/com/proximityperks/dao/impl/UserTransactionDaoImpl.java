package com.proximityperks.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.dao.UserTransactionDao;
import com.proximityperks.data.Transaction;
import com.proximityperks.data.User;
import com.proximityperks.modo.delegate.MerchantLocation;

public class UserTransactionDaoImpl extends DaoImpl implements
		UserTransactionDao {

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Transaction> getUserTransactions(List<Long> userAccountIds) {
		if (userAccountIds == null || userAccountIds.isEmpty()) {
			return null;
		}
		try {
			final String queryString = "select model from TransactionImpl model where model.userAccountId in (:userAccountIds)";
			Query query = em.createQuery(queryString);
			query.setParameter("userAccountIds", userAccountIds);
			List<Transaction> result = query.getResultList();
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

	public List<MerchantLocation> getMerchantLocations(User user) {
		if (user == null) {
			return null;
		}
		final String queryString = "select UUID() AS id, t.merchant_name, B.modo_merchant_id, B.modo_location_id, B.latitude, B.longitude from USER u, USER_ACCOUNT ua, TRANSACTION t,"
				+ "(select m.modo_merchant_id, l.modo_location_id, m.name, l.latitude, l.longitude from MERCHANT_LOCATION ml, MERCHANT m, LOCATION l "
				+ "where ml.merchant_id=m.merchant_id "
				+ "and ml.location_id=l.location_id)B where t.merchant_name=B.name and ua.user_id=u.user_id and u.user_id=:user_id and ua.user_account_id=t.user_account_id and t.rank=1";

		try {
			Query query = em.createNativeQuery(queryString,
					MerchantLocation.class);
			query.setParameter("user_id", user.getId());
			List<MerchantLocation> result = query.getResultList();
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
