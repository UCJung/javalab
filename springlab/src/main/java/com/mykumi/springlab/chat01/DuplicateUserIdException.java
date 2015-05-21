package com.mykumi.springlab.chat01;

public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(Throwable cause) {
		super(cause);
	}
}
