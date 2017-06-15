package com.verint.romannumerals;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArabicInputException extends Exception {

    private static final long serialVersionUID = 495065300109708069L;

    public InvalidArabicInputException(String message) {
        super(message);
    }

}
