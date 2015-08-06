package com.mykumi.crawler4j;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.mykumi.crawler4j.parser.ParseStrategy;
import com.mykumi.crawler4j.parser.ParseStrategy11st;

public class ParseWebPageTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() throws IOException {
		String url = "http://search.11st.co.kr/SearchPrdAction.tmall?method=getTotalSearchSeller&targetTab=T&semanticKeyword=&search=&isGnb=Y&prdType=&category=&cmd=&pageSize=&lCtgrNo=&mCtgrNo=&sCtgrNo=&dCtgrNo=&fromACK=&semanticFromGNB=&gnbTag=TO&schFrom=&ID=&ctgrNo=&srCtgrNo=&kwd=IRobot+iRobot+Braava+320+Floor+Mopping+Robot&adUrl=&adKwdTrcNo=&adPrdNo=#sortCd%%L$$pageNum%%1";
		ParseStrategy stg = new ParseStrategy11st();
		ParseWebPage pwp = new ParseWebPage(url);
		String result = pwp.getWebInfomation(stg);
	}

}
