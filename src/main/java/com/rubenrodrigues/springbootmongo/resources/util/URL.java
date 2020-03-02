package com.rubenrodrigues.springbootmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	/*
	 * Method adapted to return an Instant instead of Date.
	 */
	public static Instant convertInstant(String textDate, Instant defaultValue) {

		String textDateTime = textDate + "T00:00"; // Adding Time
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(textDateTime, formatter);
			ZonedDateTime zdt = dateTime.atZone(ZoneId.of("GMT"));
			return zdt.toInstant();
		} catch (DateTimeParseException e) {
			return defaultValue;
		}
	}

}
