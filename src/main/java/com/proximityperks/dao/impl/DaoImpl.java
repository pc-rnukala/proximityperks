package com.proximityperks.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proximityperks.dao.Dao;

public class DaoImpl implements Dao {

	protected static Logger logger = LoggerFactory.getLogger(DaoImpl.class);
	@PersistenceContext(unitName = "money2020")
	protected EntityManager em;
}
