package com.sample.employeemanagement.exceptions;

public class UsernameNotFoundException extends Exception{
    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
