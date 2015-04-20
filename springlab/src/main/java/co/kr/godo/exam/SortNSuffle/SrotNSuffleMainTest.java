package co.kr.godo.exam.SortNSuffle;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SrotNSuffleMainTest {

	@Test
	public void testSrotNSuffle() {
		String input = "4ac13bd2";
		String result = new String();
		SortNSuffle sortNSuffle = new SortNSuffle();
		
		result = sortNSuffle.doing(input);
		
		assertThat(result, is("1a2b3c4d"));
	}
}
