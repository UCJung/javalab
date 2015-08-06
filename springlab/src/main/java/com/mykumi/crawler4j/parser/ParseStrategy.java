package com.mykumi.crawler4j.parser;

import org.jsoup.nodes.Document;

public interface ParseStrategy {
	public String parsePage(Document page);
}
