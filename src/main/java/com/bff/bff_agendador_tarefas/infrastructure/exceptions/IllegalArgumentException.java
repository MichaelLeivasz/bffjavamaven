package com.bff.bff_agendador_tarefas.infrastructure.exceptions;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);

    }

    public IllegalArgumentException(String message, Throwable throwable) {
        super(message, throwable);

    }
}
