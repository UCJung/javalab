package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void sumTest() {
		Calculator calculator = new Calculator();
		int result = calculator.sum(getClass().getResource("numbers.txt").getPath());
		assertThat(result, is(15));
	}

}
