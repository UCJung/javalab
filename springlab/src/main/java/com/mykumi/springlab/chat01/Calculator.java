package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public int sum(String filepath) throws IOException {
		return fileReadTemplate(filepath, new BufferedReaderCallback() {
			@Override
			public Integer calculateWithBufferedReader(BufferedReader br)
					throws IOException {
				Integer ret = 0;
				String line = null;
				while ((line = br.readLine()) != null) {
					ret += Integer.valueOf(line); 
				}
				return ret;
			}
		});
	}
	
	public int multiply(String filepath) throws IOException {
		return 0;
	}

	public int fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException,
			NumberFormatException, FileNotFoundException {
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
}
