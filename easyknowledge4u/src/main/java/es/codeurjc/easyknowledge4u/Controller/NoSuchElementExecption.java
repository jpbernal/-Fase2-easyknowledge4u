package es.codeurjc.easyknowledge4u.Controller;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class NoSuchElementExecption {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNoTFound() {
    }

}
