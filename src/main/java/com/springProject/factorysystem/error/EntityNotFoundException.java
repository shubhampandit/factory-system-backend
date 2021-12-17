package com.springProject.factorysystem.error;

public class EntityNotFoundException extends RuntimeException {
    private EntityNotFoundException() {
        super();
    }

    private EntityNotFoundException(String message) {
        super(message);
    }
}
