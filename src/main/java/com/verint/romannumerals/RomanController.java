package com.verint.romannumerals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    @RequestMapping(value = "/roman", method = RequestMethod.GET)
    public RomanNumeral roman(@RequestParam(value = "arabic", required = true) String input)
            throws InvalidArabicInputException {
        if (input != null) {
            String trimmedInput = input.trim();
            if (trimmedInput.length() > 0) {
                try {
                    int arabic = Integer.parseInt(trimmedInput);
                    String roman = RomanNumeralConverter.convertToRoman(arabic);
                    return new RomanNumeral(arabic, roman);
                } catch (NumberFormatException e) {
                    throw new InvalidArabicInputException("Input should be an integer.");
                }
            }
        }
        throw new InvalidArabicInputException("No input supplied.");
    }

}
