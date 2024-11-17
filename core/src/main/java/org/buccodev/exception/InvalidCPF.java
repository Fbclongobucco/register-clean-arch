package org.buccodev.exception;

public class InvalidCPF extends RuntimeException {
    public InvalidCPF(String msg) {
        super(msg);
    }
}
