package com.proximityperks.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model for proxmity perks json
 * 
 * @author jponsekar
 * 
 */
public class ProxmityPerksJsonModel {
	private Object spHeader = new Object();
	private Object spData = new Object();

	public Object getSpHeader() {
		return spHeader;
	}

	public void setSpHeader(Object spHeader) {
		this.spHeader = spHeader;
	}

	public Object getSpData() {
		return spData;
	}

	public void setSpData(Object spData) {
		this.spData = spData;
	}
}
