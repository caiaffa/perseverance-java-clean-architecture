package com.caiaffa.perseverance.domain;

public class PerseveranceException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public PerseveranceException(String message) {
        super(message);
    }

}
