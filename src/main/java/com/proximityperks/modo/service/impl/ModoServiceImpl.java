package com.proximityperks.modo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.proximityperks.modo.delegate.ModoDelegate;
import com.proximityperks.modo.service.ModoService;

public class ModoServiceImpl implements ModoService {

	@Autowired
	private ModoDelegate modoDelegate;

	/**
	 * @return
	 */
	public String getModoToken() {
		return modoDelegate.getModoToken();
	}

}
