package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.verint.romannumerals.InvalidArabicInputException;
import com.verint.romannumerals.RomanController;
import com.verint.romannumerals.RomanNumeral;
import com.verint.romannumerals.RomanNumeralConverter;

public class RomanControllerTest {

    RomanController ctrl;
    RomanNumeralConverter mockedConverter;

    @Before
    public void initialise() throws InvalidArabicInputException {
        mockedConverter = mock(RomanNumeralConverter.class);
        when(mockedConverter.convertToRoman(anyInt())).thenReturn("X");
        ctrl = new RomanController(mockedConverter);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void nullParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman(null);
    }

    @Test(expected = InvalidArabicInputException.class)
    public void emptyStringParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman("");
    }

    @Test(expected = InvalidArabicInputException.class)
    public void whitespaceParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman(" \t   ");
    }

    @Test(expected = InvalidArabicInputException.class)
    public void nonIntegerParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman("hello");
    }

    @Test
    public void integerInputShouldReturnRomanNumeral() throws InvalidArabicInputException {
        RomanNumeral numeral = ctrl.roman("30");
        assertThat(numeral.getArabic(), is(30));
        assertThat(numeral.getRoman(), is("X"));
    }

    @Test
    public void integerAndWhitespaceInputShouldReturnRomanNumeral() throws InvalidArabicInputException {
        RomanNumeral numeral = ctrl.roman("\t7    ");
        assertThat(numeral.getArabic(), is(7));
        assertThat(numeral.getRoman(), is("X"));
    }
}
