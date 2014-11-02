package com.proximityperks.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.dao.UserAccountDao;
import com.proximityperks.dao.UserDao;
import com.proximityperks.data.User;
import com.proximityperks.data.UserAccount;

public class UserAccountDaoImpl extends DaoImpl implements UserAccountDao {

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserAccount> getAccounts(Long userId) {
		try {
			final String queryString = "select model from UserAccountImpl model where model.userId=:userId";
			Query query = em.createQuery(queryString);
			query.setParameter("userId", userId);
			List<UserAccount> result = query.getResultList();
			return result;
		} catch (RuntimeException re) {
			logger.error("getAccounts", re);
			throw re;
		}
	}
}
