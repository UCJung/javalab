package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadLineContext {
	public <T> T lineReadTemplate(String filepath, LineReadCallback<T> callback, T initValue) throws IOException {
		BufferedReader br = null;
		T ret = initValue;
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
