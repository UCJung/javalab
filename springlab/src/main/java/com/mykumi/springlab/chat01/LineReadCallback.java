package com.mykumi.springlab.chat01;

public interface LineReadCallback<T> {
	public abstract T calculateWithLine(String line, T value);
}
