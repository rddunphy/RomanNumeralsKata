package com.verint.romannumerals;

public class RomanNumeral {

    private final int arabic;
    private final String roman;

    public RomanNumeral(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    /**
     * @return the arabic
     */
    public int getArabic() {
        return arabic;
    }

    /**
     * @return the roman
     */
    public String getRoman() {
        return roman;
    }

}
