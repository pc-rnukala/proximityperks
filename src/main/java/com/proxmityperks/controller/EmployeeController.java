package com.proxmityperks.controller;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proximityperks.manager.ProximityPerkDbManager;
import com.proximityperks.model.Employee;

@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private ProximityPerkDbManager proximityPerkDbManager;

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = APIRequestMappings.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody
	Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999L);
		Connection connection;
		boolean status=false;
		try {
			connection = proximityPerkDbManager.getConnection();
			status = connection != null ? true : false;
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		emp.setName("Dummy"+"connection status"+status);
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
}
