package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void sumTest() throws IOException {
		Calculator calculator = new Calculator();
		int result = calculator.sum(getClass().getResource("numbers.txt").getPath());
		assertThat(result, is(15));
	}
	
	@Test(expected=FileNotFoundException.class)
	public void sumTestWithFileNotExist() throws IOException {
		Calculator calculator = new Calculator();
		calculator.sum("c:\\hellow.txt");
	}
}
