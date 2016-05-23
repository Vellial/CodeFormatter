package com.lightside.codeformatterproject.writer.writerimpl;

import com.lightside.codeformatterproject.additional.IStringGetter;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;

/**
 * String writer.
 */
public class StringWriter implements IWriter, IStringGetter {

    private StringBuilder string;

    /**
     * Constructor.
     */
    public StringWriter() {
        string = new StringBuilder();
    }

    /**
     * Write new symbols to string.
     * @param str string for writing.
     * @param repeat repeat
     */
    public void write(final String str, final int repeat) {
        int i = repeat;
        while (i > 0) {
            string.append(str);
            i--;
        }
    }

    /**
     * Delete symbol
     * @param position position of symbol.
     */
    public void delete(final int position, final int repeat) {
        int i = repeat;
        while (i > 0) {
            string.deleteCharAt(position);
            i--;
        }
    }

    /**
     * Getter for string.
     * @return string.
     */
    public String getString() {
        return string.toString();
    }
}
