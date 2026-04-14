package com.dalen.vetAppDalen.shared.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1668658851215420516L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}