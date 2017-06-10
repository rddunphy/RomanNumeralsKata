package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.verint.romannumerals.ArabicNumberOutOfBoundsException;
import com.verint.romannumerals.RomanNumeralConverter;

public class RomanNumeralTest {

    @Test
    public void shouldConvertArabicOneToRomanI() {
        assertThat(RomanNumeralConverter.convertToRoman(1), is("I"));
    }

    @Test
    public void shouldConvertArabicFiveToRomanV() {
        assertThat(RomanNumeralConverter.convertToRoman(5), is("V"));
    }

    @Test
    public void shouldConvertArabicTenToRomanX() {
        assertThat(RomanNumeralConverter.convertToRoman(10), is("X"));
    }

    @Test
    public void shouldConvertArabicFiftyToRomanL() {
        assertThat(RomanNumeralConverter.convertToRoman(50), is("L"));
    }

    @Test
    public void shouldConvertArabicHundredToRomanC() {
        assertThat(RomanNumeralConverter.convertToRoman(100), is("C"));
    }

    @Test
    public void shouldConvertArabicFiveHundredToRomanD() {
        assertThat(RomanNumeralConverter.convertToRoman(500), is("D"));
    }

    @Test
    public void shouldConvertArabicOneThousandToRomanM() {
        assertThat(RomanNumeralConverter.convertToRoman(1000), is("M"));
    }

    @Test
    public void shouldConvertArabicTwoToRepeatingI() {
        assertThat(RomanNumeralConverter.convertToRoman(2), is("II"));
    }

    @Test
    public void shouldConvertArabicThreeToTripleRepeatingI() {
        assertThat(RomanNumeralConverter.convertToRoman(3), is("III"));
    }

    @Test
    public void shouldConvertArabicSixToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(6), is("VI"));
    }

    @Test
    public void shouldConvertArabicFifteenToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(15), is("XV"));
    }

    @Test
    public void shouldConvertArabicSixtyToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(60), is("LX"));
    }

    @Test
    public void shouldConvertArabicOneHundredAndFiftyToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(150), is("CL"));
    }

    @Test
    public void shouldConvertArabicSixHundredToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(600), is("DC"));
    }

    @Test
    public void shouldConvertArabicOneThousandFiveHundredToMixedNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(1500), is("MD"));
    }

    @Test
    public void shouldConvertGreatFireOfLondonToRomanNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(1666), is("MDCLXVI"));
    }

    @Test
    public void shouldConvertArabicFourToSubtractionOfNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(4), is("IV"));
    }

    @Test
    public void shouldConvertArabicNineToSubtractionOfNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(9), is("IX"));
    }

    @Test
    public void shouldConvertArabicFourteenToAdditionAndSubtractionOfNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(14), is("XIV"));
    }

    @Test
    public void shouldConvertArabicNinetyToSubtractionOfNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(90), is("XC"));
    }

    @Test
    public void shouldConvertArabicNineHundredToSubtractionOfNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(900), is("CM"));
    }

    @Test
    public void shouldConvertArabicNinetyNineWithoutSubractingOne() {
        assertThat(RomanNumeralConverter.convertToRoman(99), is("XCIX"));
    }

    @Test
    public void shouldConvert3888ToRomanNumerals() {
        assertThat(RomanNumeralConverter.convertToRoman(3888), is("MMMDCCCLXXXVIII"));
    }

    @Test(expected = ArabicNumberOutOfBoundsException.class)
    public void shouldThrowExceptionForNegativeInput() {
        RomanNumeralConverter.convertToRoman(-10);
    }

    @Test(expected = ArabicNumberOutOfBoundsException.class)
    public void shouldThrowExceptionForZeroInput() {
        RomanNumeralConverter.convertToRoman(0);
    }

    @Test(expected = ArabicNumberOutOfBoundsException.class)
    public void shouldThrowExceptionFor3889Input() {
        RomanNumeralConverter.convertToRoman(3889);
    }
}
