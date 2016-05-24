package com.lightside.codeformatterproject.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Settings
 */
public class Settings {

    private String lineBreak;
    private char offsetSymbol;
    private int offsetLength;

    /**
     * Dpc
     * @param props sdg sdf sf
     */
    public Settings(final Properties props) {
        this.lineBreak = props.getProperty("line_break");
        this.offsetLength = Integer.valueOf(props.getProperty("offset_length"));
        this.offsetSymbol = props.getProperty("offset_symbol").charAt(0);
    }


    public char getOffsetSymbol() {
        return offsetSymbol;
    }

    public void setOffsetSymbol(final char offsetSymbol) {
        this.offsetSymbol = offsetSymbol;
    }

    public String getLineBreak() {
        return lineBreak;
    }

    public void setLineBreak(final String lineBreak) {
        this.lineBreak = lineBreak;
    }

    public int getOffsetLength() {
        return offsetLength;
    }

    public void setOffsetLength(final int offsetLength) {
        this.offsetLength = offsetLength;
    }
}
