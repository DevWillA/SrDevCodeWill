package com.willdev;

public class InvalidOptionException extends Exception {

    public InvalidOptionException() {
        super("Opción no válida.");
    }
    public InvalidOptionException(String message) {
        super(message);
    }
}
