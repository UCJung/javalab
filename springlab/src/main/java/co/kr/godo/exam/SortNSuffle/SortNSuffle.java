package co.kr.godo.exam.SortNSuffle;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortNSuffle {

	public String doing(String inputString, ShuffleStrategy stgy) {
		String numbers = collectPatternString(inputString, "\\d+");
	    String characters = collectPatternString(inputString,"[a-zA-Z]+");
	
	    char[] chars = getSortedArray(characters);
	    char[] nums = getSortedArray(numbers);
	
	    return stgy.getShuffleString(nums,chars);
	}

	public char[] getSortedArray(String input) {
		char[] chars = input.toString().toCharArray();
	    Arrays.sort(chars);
		return chars;
	}

	public String collectPatternString(String inputString, String regex) {
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(inputString);
	    StringBuilder sbResult = new StringBuilder();
	    while(matcher.find()) {
	        sbResult.append(matcher.group());
	    }
		return sbResult.toString();
	}
}
