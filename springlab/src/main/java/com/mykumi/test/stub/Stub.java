package com.mykumi.test.stub;

public class Stub implements StubInterface {

	@Override
	public Integer plus(int[] integers) {
		return 20;
	}

	@Override
	public Integer multifly(int[] integers) {
		return -20;
	}

	@Override
	public Integer minus(int[] integers) {
		return -20;
	}
}