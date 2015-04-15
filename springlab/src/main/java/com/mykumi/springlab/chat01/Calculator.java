package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public int sum(String filepath) throws IOException {
		BufferedReader br = null;
		Integer numberSum = 0;
		try {
			br = new BufferedReader(new FileReader(filepath));
			String line = null;
			while ((line = br.readLine()) != null) {
				numberSum += Integer.valueOf(line); 
			}
			return numberSum;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
