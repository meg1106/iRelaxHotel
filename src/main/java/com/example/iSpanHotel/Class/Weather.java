package com.example.iSpanHotel.Class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class Weather {

	public static void getWeather() {
		try {
			URL url = new URL("https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0003-001?Authorization=CWB-1D8048FE-4B0B-446F-8CF1-525AF90FBCAF&stationId=467490");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.connect();
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			
			String line;StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			System.out.println(sb.toString());
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void parseJSON(String json) {
		try {
			String obsTime;
			String city;
			String temp;
			String weather;
			String WDIR;
			String WDSD;
			
			JSONObject data = new JSONObject(json);
//			System.out.println(data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("weatherElement").getJSONObject(3).get("elementValue"));
			obsTime = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONObject("time").get("obsTime").toString();
			temp = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("weatherElement").getJSONObject(3).get("elementValue").toString();
			city = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("parameter").getJSONObject(0).get("parameterValue").toString();
			weather = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("weatherElement").getJSONObject(20).get("elementValue").toString();
			WDIR = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("weatherElement").getJSONObject(1).get("elementValue").toString();
			WDSD = data.getJSONObject("records").getJSONArray("location").getJSONObject(0).getJSONArray("weatherElement").getJSONObject(2).get("elementValue").toString();
			System.out.println(obsTime);
			System.out.println(city);
			System.out.println(temp);
			System.out.println(weather);
			System.out.println(WDIR);
			System.out.println(WDSD);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
