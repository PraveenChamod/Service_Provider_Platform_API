package com.ServiceProviderPlatform.Service_Provider_Platform_API.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}