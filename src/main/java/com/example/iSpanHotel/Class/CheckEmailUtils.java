package com.example.iSpanHotel.Class;

import java.util.Random;

public class CheckEmailUtils {
	
	public static String VerifyCode(int n){
        Random r = new Random();
        StringBuffer sb =new StringBuffer();
        for(int i = 0;i < n;i ++){
            int ran1 = r.nextInt(10);
            sb.append(String.valueOf(ran1));
        }
        return sb.toString();
    }

}
