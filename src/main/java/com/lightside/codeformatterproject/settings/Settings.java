package com.lightside.codeformatterproject.settings;

import java.util.Properties;

/**
 * Settings
 */
public class Settings {

    private String lineBreak;
    private char offsetSymbol;
    private int offsetLength;
    private String url;

    /**
     * Dpc
     * @param props sdg sdf sf
     */
    public Settings(final Properties props) {
        this.url = props.getProperty("url");
        this.lineBreak = props.getProperty("line_break");
        String temp = props.getProperty("offset_length");
        this.offsetLength = Integer.valueOf(temp);
        this.offsetSymbol = props.getProperty("offset_symbol").charAt(0);
    }


    public char getOffsetSymbol() {
        return offsetSymbol;
    }

    public String getLineBreak() {
        return lineBreak;
    }

    public int getOffsetLength() {
        return offsetLength;
    }

    public String getUrl() {
        return url;
    }
}
