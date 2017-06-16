package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.verint.romannumerals.InvalidArabicInputException;
import com.verint.romannumerals.RomanNumeralConverter;

public class RomanNumeralConverterTest {

    @Test
    public void shouldConvertArabicOneToRomanI() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(1), is("I"));
    }

    @Test
    public void shouldConvertArabicFiveToRomanV() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(5), is("V"));
    }

    @Test
    public void shouldConvertArabicTenToRomanX() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(10), is("X"));
    }

    @Test
    public void shouldConvertArabicFiftyToRomanL() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(50), is("L"));
    }

    @Test
    public void shouldConvertArabicHundredToRomanC() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(100), is("C"));
    }

    @Test
    public void shouldConvertArabicFiveHundredToRomanD() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(500), is("D"));
    }

    @Test
    public void shouldConvertArabicOneThousandToRomanM() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(1000), is("M"));
    }

    @Test
    public void shouldConvertArabicTwoToRepeatingI() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(2), is("II"));
    }

    @Test
    public void shouldConvertArabicThreeToTripleRepeatingI() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(3), is("III"));
    }

    @Test
    public void shouldConvertArabicSixToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(6), is("VI"));
    }

    @Test
    public void shouldConvertArabicFifteenToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(15), is("XV"));
    }

    @Test
    public void shouldConvertArabicSixtyToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(60), is("LX"));
    }

    @Test
    public void shouldConvertArabicOneHundredAndFiftyToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(150), is("CL"));
    }

    @Test
    public void shouldConvertArabicSixHundredToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(600), is("DC"));
    }

    @Test
    public void shouldConvertArabicOneThousandFiveHundredToMixedNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(1500), is("MD"));
    }

    @Test
    public void shouldConvertGreatFireOfLondonToRomanNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(1666), is("MDCLXVI"));
    }

    @Test
    public void shouldConvertArabicFourToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(4), is("IV"));
    }

    @Test
    public void shouldConvertArabicNineToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(9), is("IX"));
    }

    @Test
    public void shouldConvertArabicFourteenToAdditionAndSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(14), is("XIV"));
    }

    @Test
    public void shouldConvertArabicNinetyToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(90), is("XC"));
    }

    @Test
    public void shouldConvertArabicNineHundredToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(900), is("CM"));
    }

    @Test
    public void shouldConvertArabicNinetyNineWithoutSubractingOne() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(99), is("XCIX"));
    }

    @Test
    public void shouldConvert3888ToRomanNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(3888), is("MMMDCCCLXXXVIII"));
    }

    @Test
    public void shouldConvert3999ToRomanNumerals() throws InvalidArabicInputException {
        assertThat(RomanNumeralConverter.convertToRoman(3999), is("MMMCMXCIX"));
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionForNegativeInput() throws InvalidArabicInputException {
        RomanNumeralConverter.convertToRoman(-10);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionForZeroInput() throws InvalidArabicInputException {
        RomanNumeralConverter.convertToRoman(0);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionFor4000Input() throws InvalidArabicInputException {
        RomanNumeralConverter.convertToRoman(4000);
    }
}
