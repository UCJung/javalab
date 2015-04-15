package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	
	private Calculator calculator;
	private String filepath;

	@Before
	public void setUp() {
		calculator = new Calculator();
		filepath = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumTest() throws IOException {
		
		int result = calculator.sum(filepath);
		assertThat(result, is(15));
	}
	
	@Test
	public void multiplyTest() throws IOException {
		int result = calculator.multiply(filepath);
		assertThat(result, is(120));
	}
	
	@Test
	public void concatenateTest() throws IOException {
		String result = calculator.concatenate(filepath);
		assertThat(result, is("12345"));
	}
	
	@Test(expected=FileNotFoundException.class)
	public void sumTestWithFileNotExist() throws IOException {

		String failFilePath = "c:\\hellow.txt";
		calculator.sum(failFilePath);
	}
}
