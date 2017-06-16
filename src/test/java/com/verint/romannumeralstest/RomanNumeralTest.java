package com.verint.romannumeralstest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.verint.romannumerals.RomanNumeral;

public class RomanNumeralTest {

    private RomanNumeral numeral;

    @Before
    public void initialise() {
        numeral = new RomanNumeral(3, "III");
    }

    @Test
    public void arabicValueShouldBeDeterminedByConstructor() {
        assertThat(numeral.getArabic(), is(3));
    }

    @Test
    public void romanValueShouldBeDeterminedByConstructor() {
        assertThat(numeral.getRoman(), is("III"));
    }

}
