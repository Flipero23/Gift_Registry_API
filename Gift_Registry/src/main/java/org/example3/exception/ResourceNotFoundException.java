package org.example3.exception;

//Custom exception that is thrown when a requested resource is not found
public class ResourceNotFoundException extends RuntimeException {
    //Constructor that takes a message saying which resource was not found
    public ResourceNotFoundException(String message) {
        super(message);   //Pass the message to the parent RuntimeException class
    }
}
