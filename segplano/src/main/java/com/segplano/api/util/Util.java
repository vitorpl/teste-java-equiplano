package com.segplano.api.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Util {

	public static Date localDateToDate(LocalDate ld) {
		return Date.from(LocalDateTime.of(ld, LocalTime.of(0, 0, 0))
				.atZone(ZoneId.systemDefault()).toInstant());
	}
}
