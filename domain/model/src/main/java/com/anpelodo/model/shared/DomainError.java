package com.anpelodo.model.shared;

public abstract class DomainError extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    protected DomainError(String errorCode, String errorMessage) {
        super(errorMessage);

        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}