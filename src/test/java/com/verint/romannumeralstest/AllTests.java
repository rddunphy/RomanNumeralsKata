package com.verint.romannumeralstest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RomanControllerTest.class, RomanNumeralConverterTest.class, RomanNumeralTest.class })
public class AllTests {

}
