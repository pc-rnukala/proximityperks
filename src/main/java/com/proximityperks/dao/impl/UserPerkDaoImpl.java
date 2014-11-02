package com.proximityperks.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.dao.UserPerkDao;
import com.proximityperks.data.User;
import com.proximityperks.data.UserPerk;

public class UserPerkDaoImpl extends DaoImpl implements UserPerkDao {

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserPerk> getUserPerks() {
		try {
			final String queryString = "select model from UserPerkImpl model";
			Query query = em.createQuery(queryString);
			List<UserPerk> result = query.getResultList();
			if (result != null && result.size() > 0) {
				return result;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			logger.error("getUserPerks", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserPerk> getUserPerks(final User user) {
		try {
			final String queryString = "select model from UserPerkImpl model where model.userId=:userId";
			Query query = em.createQuery(queryString);
			query.setParameter("userId", user.getId());
			List<UserPerk> result = query.getResultList();
			if (result != null && result.size() > 0) {
				return result;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			logger.error("getUserPerks", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public UserPerk getUserPerkById(Long userPerkId) {
		try {
			final String queryString = "select model from UserPerkImpl model where model.id=:userPerkId";
			Query query = em.createQuery(queryString);
			query.setParameter("userPerkId", userPerkId);
			List<UserPerk> result = query.getResultList();
			if (result != null && result.size() > 0) {
				return result.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			logger.error("getUserPerkById", re);
			throw re;
		}

	}

	/**
	 * This is to create user
	 */
	@Transactional(value = "proximityPerksTran", readOnly = false, propagation = Propagation.REQUIRED)
	public UserPerk saveOrUpdate(UserPerk userPerk) {
		if (userPerk == null) {
			return null;
		}
		UserPerk createdUserPerk = em.merge(userPerk);
		return createdUserPerk;
	}

	@Transactional(value = "proximityPerksTran", readOnly = false, propagation = Propagation.REQUIRED)
	public boolean deleteUserPerk(UserPerk userPerk) {
		if (userPerk == null) {
			return false;
		}
		try {
			em.remove(userPerk);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
