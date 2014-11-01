package com.proximityperks.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proximityperks.dao.UserDao;
import com.proximityperks.data.User;

public class UserDaoImpl extends DaoImpl implements UserDao {

	@SuppressWarnings("unchecked")
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<User> getUsers() {
		try {
			final String queryString = "select model from UserImpl model";
			Query query = em.createQuery(queryString);
			List<User> result = query.getResultList();
			if (result != null && result.size() > 0) {
				return result;
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			logger.error("getUsers", re);
			throw re;
		}
	}

	/**
	 * Get user by user name
	 * 
	 * @param userName
	 * @return
	 */
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public User getUser(String userName) {
		try {
			final String queryString = "select model from UserImpl model where model.userName=:userName";
			Query query = em.createQuery(queryString);
			query.setParameter("userName", userName);
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception re) {
			logger.error("getUser", re);
			throw re;
		}
	}

	/**
	 * Get user by user name
	 * 
	 * @param userName
	 * @return
	 */
	@Transactional(value = "proximityPerksTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public User getUserByGuid(String userGuid) {
		try {
			final String queryString = "select model from UserImpl model where model.userGuid=:userGuid";
			Query query = em.createQuery(queryString);
			query.setParameter("userGuid", userGuid);
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception re) {
			logger.error("getUserByGuid", re);
			throw re;
		}
	}

	/**
	 * This is to create user
	 */
	@Transactional(value = "proximityPerksTran", readOnly = false, propagation = Propagation.REQUIRED)
	public User saveOrUpdate(User user) {
		if (user == null) {
			return null;
		}
		User createdUser = em.merge(user);
		return createdUser;
	}

	@Transactional(value = "proximityPerksTran", readOnly = false, propagation = Propagation.REQUIRED)
	public boolean deleteUser(User user) {
		if (user == null) {
			return false;
		}
		try {
			em.remove(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
