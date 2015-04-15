package com.mykumi.springlab.chat01;

import java.io.IOException;

public class Calculator {
	private FileReadLineContext fileReadLineContext;
	public void setFileReadLineContext(FileReadLineContext fileReadLineContext) {
		this.fileReadLineContext = fileReadLineContext;
	}
	
	public int sum(String filepath) throws IOException {
		return fileReadLineContext.lineReadTemplate(filepath, new LineReadCallback<Integer>() {
			public Integer calculateWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		}, 0);
	}
	
	public int multiply(String filepath) throws IOException {
		return fileReadLineContext.lineReadTemplate(filepath, new LineReadCallback<Integer>() {
			public Integer calculateWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		}, 1);
	}
	
	public String concatenate(String filepath) throws IOException {
		return fileReadLineContext.lineReadTemplate(filepath, new LineReadCallback<String>() {
			public String calculateWithLine(String line, String value) {
				return value + line;
			}
		} , "");
	}
}
