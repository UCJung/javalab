package com.mykumi.springlab.exam;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {

	public abstract Integer calculateWithBufferedReader(BufferedReader br) throws IOException;

}