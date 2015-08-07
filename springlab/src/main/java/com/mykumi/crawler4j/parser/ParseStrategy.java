package com.mykumi.crawler4j.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;

public interface ParseStrategy {
	public final List<Map<String, String>> products = new ArrayList<Map<String,String>>();

	public String parsePage(Document page);
}
