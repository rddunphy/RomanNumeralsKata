package com.verint.romannumerals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralConverter {

    private Map<Integer, String> arabicToRoman;
    private Set<Integer> subtractables;

    public RomanNumeralConverter() {
        arabicToRoman = new LinkedHashMap<>();
        arabicToRoman.put(1000, "M");
        arabicToRoman.put(500, "D");
        arabicToRoman.put(100, "C");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(1, "I");

        subtractables = new HashSet<>();
        subtractables.addAll(Arrays.asList(1, 10, 100));
    }

    public String convertToRoman(int arabic) throws InvalidArabicInputException {
        if (arabic <= 0) {
            throw new InvalidArabicInputException("Input should be greater than zero.");
        }
        if (arabic > 3999) {
            throw new InvalidArabicInputException("Input should be less than 4000.");
        }
        int thousands = arabic / 1000;
        int hundreds = (arabic % 1000) / 100;
        int tens = (arabic % 100) / 10;
        int ones = arabic % 10;
        return convertModularisedToRoman(thousands * 1000) + convertModularisedToRoman(hundreds * 100)
                + convertModularisedToRoman(tens * 10) + convertModularisedToRoman(ones);
    }

    private String convertModularisedToRoman(int arabic) {
        if (arabic == 0) {
            return "";
        }
        for (Integer subtractable : subtractables) {
            if (arabicToRoman.containsKey(arabic + subtractable)) {
                return arabicToRoman.get(subtractable) + arabicToRoman.get(arabic + subtractable);
            }
        }

        int largestSingleNumeralArabicValue = getLargestSingleNumeralArabicValue(arabic);
        String roman = arabicToRoman.get(largestSingleNumeralArabicValue);
        int remainder = arabic - largestSingleNumeralArabicValue;
        if (remainder != 0) {
            roman += convertModularisedToRoman(remainder);
        }
        return roman;
    }

    private int getLargestSingleNumeralArabicValue(int arabic) {
        for (int arabicKey : arabicToRoman.keySet()) {
            if (arabicKey <= arabic) {
                return arabicKey;
            }
        }
        return 0;
    }

}
