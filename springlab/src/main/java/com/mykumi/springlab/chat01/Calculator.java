package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public int sum(String filepath) throws IOException {
		return fileReadTemplate(filepath);
	}

	public int fileReadTemplate(String filepath) throws IOException,
			NumberFormatException, FileNotFoundException {
		BufferedReader br = null;
		Integer ret = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));
			ret = calcSumWithBufferedRead(br, ret);
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

	public Integer calcSumWithBufferedRead(BufferedReader br, Integer ret)
			throws IOException, NumberFormatException {
		String line = null;
		while ((line = br.readLine()) != null) {
			ret += Integer.valueOf(line); 
		}
		return ret;
	}
}
