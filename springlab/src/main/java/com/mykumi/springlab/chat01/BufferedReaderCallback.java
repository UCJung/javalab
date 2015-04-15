package com.mykumi.springlab.chat01;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {

	public abstract Integer calculateWithBufferedReader(BufferedReader br) throws IOException;

}