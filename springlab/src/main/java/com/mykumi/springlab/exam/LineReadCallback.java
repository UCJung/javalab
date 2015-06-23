package com.mykumi.springlab.exam;

public interface LineReadCallback<T> {
	public abstract T calculateWithLine(String line, T value);
}
