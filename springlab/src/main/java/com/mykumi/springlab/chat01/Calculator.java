package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public int sum(String filepath) throws IOException {
		return lineReadTemplate(filepath, new LineReadCallback() {
			@Override
			public Integer calculateWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		}, 0);
	}
	
	public int multiply(String filepath) throws IOException {
		return lineReadTemplate(filepath, new LineReadCallback() {
			@Override
			public Integer calculateWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		}, 1);
	}

	public int fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
		BufferedReader br = null;
		Integer ret = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));
			ret = callback.calculateWithBufferedReader(br);
			return ret;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (br != null) {
				try { br.close(); } 
				catch (Exception e) {}
			}
		}
	}
	
	public int lineReadTemplate(String filepath, LineReadCallback callback, int initValue) throws IOException {
		BufferedReader br = null;
		Integer ret = initValue;
		try {
			br = new BufferedReader(new FileReader(filepath));
			String line = null;
			while ((line = br.readLine()) != null) {
				ret = callback.calculateWithLine(line, ret);
			}
			return ret;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (br != null) {
				try { br.close(); } 
				catch (Exception e) {}
			}
		}
	}	
}
