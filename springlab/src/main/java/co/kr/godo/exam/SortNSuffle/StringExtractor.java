package co.kr.godo.exam.SortNSuffle;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtractor {
	private String regEx;
	private String exTractedString;
	private char[] sortedStringArray;

	public StringExtractor(String regEx) {
		this.regEx = regEx;
	}

	public void extractPatternString(String inputString) {
		Pattern pattern = Pattern.compile(regEx);
	    Matcher matcher = pattern.matcher(inputString);
	    StringBuilder sbResult = new StringBuilder();
	    while(matcher.find()) {
	        sbResult.append(matcher.group());
	    }
	    exTractedString = sbResult.toString();
	}
	
	public void exTractStringToSortedArray() {
		char[] chars = exTractedString.toString().toCharArray();
	    Arrays.sort(chars);
	    sortedStringArray = chars;
	}	
	
	public String getExtractedString() {
		return this.exTractedString;
	}
	
	public char[] getSortedArray() {
		return this.sortedStringArray;
	}
}
