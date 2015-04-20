package co.kr.godo.exam.SortNSuffle;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortNSuffle {

	public String doing(String inputString) {
		String numbers = collectPatternString(inputString, "\\d+");
	    String characters = collectPatternString(inputString,"[a-zA-Z]+");
	
	    char[] chars = getSortedArray(characters);
	    char[] nums = getSortedArray(numbers);
	
	    String result = getShuffleString(chars, nums);
	    return result.toString();
	}

	public String getShuffleString(char[] chars, char[] nums) {
		int charsLength = chars.length;
	    int numsLength = nums.length;
	    int limit = (charsLength > numsLength) ? charsLength : numsLength;
	    StringBuilder sbResult = new StringBuilder();
	    for ( int i = 0 ; i < limit ; i ++ ){
	        if (numsLength > i ) sbResult.append(nums[i]);
	        if (charsLength > i ) sbResult.append(chars[i]);
	    }
		return sbResult.toString();
	}

	public char[] getSortedArray(String input) {
		char[] chars = input.toString().toCharArray();
	    Arrays.sort(chars);
		return chars;
	}

	public String collectPatternString(String inputString, String regex) {
		// collect character string
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(inputString);
	    StringBuilder sbResult = new StringBuilder();
	    while(matcher.find()) {
	        sbResult.append(matcher.group());
	    }
		return sbResult.toString();
	}
}
