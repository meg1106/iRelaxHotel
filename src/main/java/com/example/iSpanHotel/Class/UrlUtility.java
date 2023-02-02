package com.example.iSpanHotel.Class;

import jakarta.servlet.http.HttpServletRequest;

public class UrlUtility {
	public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
