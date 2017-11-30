package com.fortuneforall.info.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InfoDAO {
	public String zodiac (String birth) {
		int year = (Integer.parseInt(birth.substring(0,4))-1900)%12;
		System.out.println("year:"+year);
		switch(year) {
		
			case 8: return "원숭이띠 운세";
			case 9: return "닭띠 운세";
			case 10: return "개띠 운세";
			case 11: return "돼지띠 운세";
			case 0: return "쥐띠 운세";
			case 1: return "소띠 운세";
			case 2: return "범띠 운세";
			case 3: return "토끼띠 운세";
			case 4: return "용띠 운세";
			case 5: return "뱀띠 운세";
			case 6: return "말띠 운세";
			case 7: return "양띠 운세";
			
			default : return null;
		}
	}
	
	public String star(String birth) {
		int date = (Integer.parseInt(birth.substring(5)));
		System.out.println(date);
		
		if(date>=121 && date<=218) {
			return "물병자리";
		}
		if(date>=219 && date<=320) {
			return "물고기자리";
		}
		if(date>=321 && date<=420) {
			return "양자리";
		}
		if(date>=421 && date<=520) {
			return "황소자리";
		}
		if(date>=521 && date<=621) {
			return "쌍둥이자리";
		}
		if(date>=622 && date<=722) {
			return "게자리";
		}
		if(date>=723 && date<=822) {
			return "사자자리";
		}
		if(date>=823 && date<=922) {
			return "처녀자리";
		}
		if(date>=923 && date<=1023) {
			return "천칭자리";
		}
		if(date>=1024 && date<=1122) {
			return "전갈자리";
		}
		if(date>=1123 && date<=1221) {
			return "사수자리";
		}
		if(date>=1222 && date<=120) {
			return "염소자리";
		}
		return null;
	}
}
