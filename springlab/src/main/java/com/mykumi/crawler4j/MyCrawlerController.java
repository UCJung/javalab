package com.mykumi.crawler4j;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class MyCrawlerController {

	public static void main(String[] args) throws Exception {
		String crawlStorageFolder = "/data/crawl/root";
		int numberOfCrawlers = 7;
		
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setPolitenessDelay(500);
		config.setMaxDepthOfCrawling(2);
		config.setMaxPagesToFetch(1000);
		config.setResumableCrawling(false);
		
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController crawlController = new CrawlController(config, pageFetcher, robotstxtServer);
		
		crawlController.addSeed("http://www.11st.co.kr/html/main.html");
		crawlController.addSeed("http://www.11st.co.kr/html/category/1930.html");
		
		crawlController.start(MyCrawler.class, numberOfCrawlers);
	}
}
