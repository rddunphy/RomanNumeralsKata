package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.verint.romannumerals.InvalidArabicInputException;
import com.verint.romannumerals.RomanController;
import com.verint.romannumerals.RomanNumeral;

public class RomanControllerTest {

    RomanController ctrl;

    @Before
    public void initialise() {
        ctrl = new RomanController();
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

    @Test(expected = InvalidArabicInputException.class)
    public void negativeParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman("-5");
    }

    @Test(expected = InvalidArabicInputException.class)
    public void positiveOutOfRangeParameterShouldCauseException() throws InvalidArabicInputException {
        ctrl.roman("10000");
    }

    @Test
    public void integerInputShouldReturnRomanNumeral() throws InvalidArabicInputException {
        RomanNumeral numeral = ctrl.roman("30");
        assertThat(numeral.getArabic(), is(30));
        assertThat(numeral.getRoman(), is("XXX"));
    }

    @Test
    public void integerAndWhitespaceInputShouldReturnRomanNumeral() throws InvalidArabicInputException {
        RomanNumeral numeral = ctrl.roman("\t7    ");
        assertThat(numeral.getArabic(), is(7));
        assertThat(numeral.getRoman(), is("VII"));
    }
}
