package co.kr.godo.exam.SortNSuffle;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SrotNSuffleMainTest {

	@Test
	public void testSrotNSuffle() {
		String inputString = "4ac13bd2";
		String result = new String();
		SortNSuffle sortNSuffle = new SortNSuffle();
		
		result = sortNSuffle.doing(inputString);
		
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
}
