package com.example.iSpanHotel.Class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
	public static List<String> getBetweenDates(String startTime, String endTime, boolean isIncludeStartTime) {
		List<String> result = new ArrayList<>();
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startTime);
			Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
			Calendar dd = Calendar.getInstance();
			dd.setTime(d1);
			while (dd.getTime().before(d2)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String str = sdf.format(dd.getTime());
				result.add(str);
				dd.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
