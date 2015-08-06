package com.mykumi.crawler4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.mykumi.crawler4j.parser.ParseStrategy;
import com.mykumi.crawler4j.parser.ParseStrategy11st;

public class PriveCompareClient {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
//		while (true) {
			String productName = sc.next().replace(" ", "+");
			System.out.println(productName);
			//if (productName.equals("0")) break;
			String url = "http://search.11st.co.kr/SearchPrdAction.tmall?method=getTotalSearchSeller&targetTab=T&semanticKeyword=&search=&isGnb=Y&prdType=&category=&cmd=&pageSize=&lCtgrNo=&mCtgrNo=&sCtgrNo=&dCtgrNo=&fromACK=&semanticFromGNB=&gnbTag=TO&schFrom=&ID=&ctgrNo=&srCtgrNo=&kwd=" + productName + "&adUrl=&adKwdTrcNo=&adPrdNo=#sortCd%%L$$pageNum%%1";
			
			System.out.println(url);
			getProductList(url);		
//		}
	}

	private static void getProductList(String url) {
		ParseStrategy stg = new ParseStrategy11st();
		ParseWebPage pwp = null;
		try {
			pwp = new ParseWebPage(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String result = pwp.getWebInfomation(stg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
