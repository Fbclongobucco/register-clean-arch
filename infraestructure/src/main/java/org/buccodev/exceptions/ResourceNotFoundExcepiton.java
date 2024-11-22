package org.buccodev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepiton extends RuntimeException{

    public ResourceNotFoundExcepiton(Object id) {
        super("resource "+id+" not found!");
    }
}
