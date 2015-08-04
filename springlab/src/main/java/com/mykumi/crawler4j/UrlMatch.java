package com.mykumi.crawler4j;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

public class UrlMatch {

	@Test
	public void test() {
		Pattern FILTERS = Pattern.compile(".+(sellerproductdetail\\.(tmall\\?))+.+");
		String url = "http://www.11st.co.kr/product/sellerproductdetail.tmall?method=getsellerproductdetail&prdno=1290775440";
		

		System.out.println(FILTERS.matcher(url).matches());
		
		String str = "123,111.99";
		Float flt = Float.valueOf(str.replaceAll("[^0-9\\.]", ""));
		System.out.println(flt);
	}

}
