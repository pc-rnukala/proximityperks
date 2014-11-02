package com.proximityperks.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProximityPerksUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(ProximityPerksUtil.class);

	public static String getFormattedDate(Date date) {
		if (date == null) {
			return "";
		}
		String formattedDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = sdf.format(date);
		} catch (Exception e) {
			logger.error("Exception occurred", e);
		}
		return formattedDate;
	}

	public static String getFormattedAmount(Double amount) {
		if (amount == null || amount.isNaN() || amount.isInfinite()) {
			return "";
		}
		String formattedAmount = "";
		try {
			DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
			decimalFormatSymbols.setDecimalSeparator('.');
			decimalFormatSymbols.setGroupingSeparator(',');
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00",
					decimalFormatSymbols);
			formattedAmount = decimalFormat.format(amount);
		} catch (Exception e) {
			logger.error("Exception occurred", e);
		}
		return formattedAmount;
	}
}
