package co.kr.godo.exam.SortNSuffle;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SrotNSuffleMainTest {

	@Test
	public void testSrotNSuffle() {
		String inputString = "4ac13bd2";
		SortNSuffle sortNSuffle = new SortNSuffle(inputString);
		
		String result = sortNSuffle.doing(new NumberCharacterShuffleStrategy());
		
		assertThat(result, is("1a2b3c4d"));
	}
	
	@Test
	public void collectPatternString() {
		String inputString = "4ac13bd2";
		SortNSuffle sortNSuffle = new SortNSuffle(inputString);
		
		String testNumber = sortNSuffle.collectPatternString("\\d+");
		assertThat(testNumber, is("4132"));
		
		String testCharacter = sortNSuffle.collectPatternString("[a-zA-Z]+");
		assertThat(testCharacter, is("acbd"));
	}
	
	@Test
	public void getSortedArrayTest() {
		String inputString = "4ac13bd2";
		SortNSuffle sortNSuffle = new SortNSuffle(inputString);
		
		char[] sortedString =sortNSuffle.getSortedArray(inputString);
		assertThat(sortedString.length, is(8));
		assertThat(sortedString[0],is('1'));
		assertThat(sortedString[1],is('2'));
		assertThat(sortedString[2],is('3'));
		assertThat(sortedString[3],is('4'));
		assertThat(sortedString[4],is('a'));
		assertThat(sortedString[5],is('b'));
		assertThat(sortedString[6],is('c'));
		assertThat(sortedString[7],is('d'));
	}
}
