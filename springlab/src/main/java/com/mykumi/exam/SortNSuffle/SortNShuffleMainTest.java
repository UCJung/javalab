package com.mykumi.exam.SortNSuffle;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SortNShuffleMainTest {

	@Test
	public void testSrotNSuffle() {
		String inputString = "4ac13bd2";
		SortNShuffle sortNSuffle = new SortNShuffle(inputString);
		
		String result = sortNSuffle.doing(new NumberCharacterShuffleStrategy());
		
		assertThat(result, is("1a2b3c4d"));
	}
	
	@Test
	public void collectPatternString() {
		String inputString = "4ac13bd2";
		SortNShuffle sortNSuffle = new SortNShuffle(inputString);
		
		sortNSuffle.setExtractor("\\d+", "[a-zA-Z]+");
		assertThat(sortNSuffle.doing(new NumberCharacterShuffleStrategy()), is("1a2b3c4d"));
		
	}
	
	@Test
	public void getSortedArrayTest() {
		String inputString = "4ac13bd2";
		SortNShuffle sortNSuffle = new SortNShuffle(inputString);
		
		StringExtractor se1 = new StringExtractor("\\d+");
		se1.extractPatternString(inputString);
		assertThat(se1.getExtractedString(), is("4132"));
		
		se1.exTractStringToSortedArray();
		char[] se1srotedArray = se1.getSortedArray();
		assertThat(se1srotedArray.length, is(4));
		assertThat(se1srotedArray[0],is('1'));
		assertThat(se1srotedArray[1],is('2'));
		assertThat(se1srotedArray[2],is('3'));
		assertThat(se1srotedArray[3],is('4'));
		
		
		StringExtractor se2 = new StringExtractor("[a-zA-Z]+");

		se2.extractPatternString(inputString);
		assertThat(se2.getExtractedString(), is("acbd")); 
		
		se2.exTractStringToSortedArray();
		char[] se2srotedArray = se2.getSortedArray();
		assertThat(se2srotedArray.length, is(4));
		assertThat(se2srotedArray[0],is('a'));
		assertThat(se2srotedArray[1],is('b'));
		assertThat(se2srotedArray[2],is('c'));
		assertThat(se2srotedArray[3],is('d'));
		
		assertThat(sortNSuffle.doing(new NumberCharacterShuffleStrategy()),is("1a2b3c4d")); 
	}
}
