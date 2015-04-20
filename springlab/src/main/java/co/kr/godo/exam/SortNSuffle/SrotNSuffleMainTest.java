package co.kr.godo.exam.SortNSuffle;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SrotNSuffleMainTest {

	private class NumberCharacterShuffleStrategy implements SuffleStrategy {
		@Override
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
	}

	@Test
	public void testSrotNSuffle() {
		String inputString = "4ac13bd2";
		String result = new String();
		SortNSuffle sortNSuffle = new SortNSuffle();
		
		result = sortNSuffle.doing(inputString, new NumberCharacterShuffleStrategy());
		
		assertThat(result, is("1a2b3c4d"));
	}
	
	@Test
	public void collectPatternString() {
		String inputString = "4ac13bd2";
		SortNSuffle sortNSuffle = new SortNSuffle();
		
		String testNumber = sortNSuffle.collectPatternString(inputString, "\\d+");
		assertThat(testNumber, is("4132"));
		
		String testCharacter = sortNSuffle.collectPatternString(inputString,"[a-zA-Z]+");
		assertThat(testCharacter, is("acbd"));
	}
	
	@Test
	public void getSortedArrayTest() {
		String input = "abdec";
		SortNSuffle sortNSuffle = new SortNSuffle();
		
		char[] sortedString =sortNSuffle.getSortedArray(input);
		assertThat(sortedString.length, is(5));
		assertThat(sortedString[0],is('a'));
		assertThat(sortedString[1],is('b'));
		assertThat(sortedString[2],is('c'));
		assertThat(sortedString[3],is('d'));
		assertThat(sortedString[4],is('e'));
	}
}
