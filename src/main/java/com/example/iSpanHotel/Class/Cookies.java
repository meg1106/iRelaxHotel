package com.example.iSpanHotel.Class;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Cookies {
	
	public static void setCookies(String token, HttpServletResponse response) {
		Cookie cookie = new Cookie("UID",token);
//		cookie.setHttpOnly(true);
		cookie.setMaxAge(30*24*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static void removeCookies(HttpServletResponse response) {
		Cookie cookie = new Cookie("UID",null);
		cookie.setMaxAge(0);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
