package com.proximityperks.manager;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class ProximityPerkDbManager {
	
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
}
