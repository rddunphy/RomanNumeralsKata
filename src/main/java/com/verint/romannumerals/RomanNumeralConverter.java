package com.verint.romannumerals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RomanNumeralConverter {

    private static Map<Integer, String> arabicToRoman;
    private static Set<Integer> subtractables;

    static {
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

    public static String convertToRoman(int arabic) {
        if (arabic <= 0) {
            throw new ArabicNumberOutOfBoundsException("Input is negative or zero.");
        }
        if (arabic > 3888) {
            throw new ArabicNumberOutOfBoundsException("Input is greater than 3888.");
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
            roman += convertToRoman(remainder);
        }
        return roman;
    }

    private static int getLargestSingleNumeralArabicValue(int arabic) {
        for (int arabicKey : arabicToRoman.keySet()) {
            if (arabicKey <= arabic) {
                return arabicKey;
            }
        }
        return 0;
    }

}
