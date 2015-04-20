package co.kr.godo.exam.SortNSuffle;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortNSuffle {

	public String doing(String inputString) {
		// collect number string
	    Pattern numberPattern = Pattern.compile("\\d+");
	    Matcher matcher = numberPattern.matcher(inputString);
	    StringBuilder numbers = new StringBuilder();
	    while(matcher.find()) {
	        numbers.append(matcher.group());
	    }
	
	    // collect character string
	    Pattern characterPattern = Pattern.compile("[a-zA-Z]+");
	    matcher = characterPattern.matcher(inputString);
	    StringBuilder characters = new StringBuilder();
	    while(matcher.find()) {
	        characters.append(matcher.group());
	    }
	
	    // covert string to character array
	    char[] chars = characters.toString().toCharArray();
	    char[] nums = numbers.toString().toCharArray();
	
	    // sort character array
	    Arrays.sort(chars);
	    Arrays.sort(nums);
	
	    // print result
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

}
