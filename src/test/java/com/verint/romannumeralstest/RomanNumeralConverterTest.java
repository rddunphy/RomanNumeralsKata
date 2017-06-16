package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.verint.romannumerals.InvalidArabicInputException;
import com.verint.romannumerals.RomanNumeralConverter;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter;

    @Before
    public void initialise() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void shouldConvertArabicOneToRomanI() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(1), is("I"));
    }

    @Test
    public void shouldConvertArabicFiveToRomanV() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(5), is("V"));
    }

    @Test
    public void shouldConvertArabicTenToRomanX() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(10), is("X"));
    }

    @Test
    public void shouldConvertArabicFiftyToRomanL() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(50), is("L"));
    }

    @Test
    public void shouldConvertArabicHundredToRomanC() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(100), is("C"));
    }

    @Test
    public void shouldConvertArabicFiveHundredToRomanD() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(500), is("D"));
    }

    @Test
    public void shouldConvertArabicOneThousandToRomanM() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(1000), is("M"));
    }

    @Test
    public void shouldConvertArabicTwoToRepeatingI() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(2), is("II"));
    }

    @Test
    public void shouldConvertArabicThreeToTripleRepeatingI() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(3), is("III"));
    }

    @Test
    public void shouldConvertArabicSixToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(6), is("VI"));
    }

    @Test
    public void shouldConvertArabicFifteenToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(15), is("XV"));
    }

    @Test
    public void shouldConvertArabicSixtyToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(60), is("LX"));
    }

    @Test
    public void shouldConvertArabicOneHundredAndFiftyToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(150), is("CL"));
    }

    @Test
    public void shouldConvertArabicSixHundredToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(600), is("DC"));
    }

    @Test
    public void shouldConvertArabicOneThousandFiveHundredToMixedNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(1500), is("MD"));
    }

    @Test
    public void shouldConvertGreatFireOfLondonToRomanNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(1666), is("MDCLXVI"));
    }

    @Test
    public void shouldConvertArabicFourToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(4), is("IV"));
    }

    @Test
    public void shouldConvertArabicNineToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(9), is("IX"));
    }

    @Test
    public void shouldConvertArabicFourteenToAdditionAndSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(14), is("XIV"));
    }

    @Test
    public void shouldConvertArabicNinetyToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(90), is("XC"));
    }

    @Test
    public void shouldConvertArabicNineHundredToSubtractionOfNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(900), is("CM"));
    }

    @Test
    public void shouldConvertArabicNinetyNineWithoutSubractingOne() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(99), is("XCIX"));
    }

    @Test
    public void shouldConvert3888ToRomanNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(3888), is("MMMDCCCLXXXVIII"));
    }

    @Test
    public void shouldConvert3999ToRomanNumerals() throws InvalidArabicInputException {
        assertThat(converter.convertToRoman(3999), is("MMMCMXCIX"));
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionForNegativeInput() throws InvalidArabicInputException {
        converter.convertToRoman(-10);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionForZeroInput() throws InvalidArabicInputException {
        converter.convertToRoman(0);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void shouldThrowExceptionFor4000Input() throws InvalidArabicInputException {
        converter.convertToRoman(4000);
    }
}
