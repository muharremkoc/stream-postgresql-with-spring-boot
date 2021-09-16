package com.example.streamwithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Error: User is Not Found!")
public class UserNotFoundException extends RuntimeException {
}
