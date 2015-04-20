package co.kr.godo.exam.SortNSuffle;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortNSuffle {

	private String inputString;
	private String regexNumber;
	private String regexCharacter;

	public SortNSuffle(String inputString) {
		this.inputString = inputString;
		this.regexNumber = "\\d+";
		this.regexCharacter = "[a-zA-Z]+";		
	}
	
	public SortNSuffle(String inputString, String regexNumber, String regexCharacter) {
		this.inputString = inputString;
		this.regexNumber = regexNumber;
		this.regexCharacter = regexCharacter;
	}
	
	public String doing(ShuffleStrategy stgy) {
		String numbers = collectPatternString(regexNumber);
		String characters = collectPatternString(regexCharacter);
	
	    char[] chars = getSortedArray(characters);
	    char[] nums = getSortedArray(numbers);
	
	    return stgy.getShuffleString(nums,chars);
	}

	public char[] getSortedArray(String input) {
		char[] chars = input.toString().toCharArray();
	    Arrays.sort(chars);
		return chars;
	}

	public String collectPatternString(String regex) {
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(inputString);
	    StringBuilder sbResult = new StringBuilder();
	    while(matcher.find()) {
	        sbResult.append(matcher.group());
	    }
		return sbResult.toString();
	}
}
