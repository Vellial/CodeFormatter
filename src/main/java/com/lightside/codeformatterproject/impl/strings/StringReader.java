package com.lightside.codeformatterproject.impl.strings;

import com.lightside.codeformatterproject.IReader;
import com.lightside.codeformatterproject.IReaderException;

/**
 * Class for reading from string.
 */
public class StringReader implements IReader {
    private String string;
    private char[] chars;
    private int index;

    /**
     * Constructor.
     * @param str string for reading.
     */
    public StringReader(final String str) {
        this.string = str;
        chars = str.toCharArray();
        index = 0;
    }

    /**
     * Read symbol from string.
     * @return char symbol from string.
     * @throws IReaderException reader exception.
     */
    public char read() throws IReaderException {
        char cursymbol = chars[index];
        index++;
        return cursymbol;
    }

    /**
     * Get length for string.
     * @return length.
     */
    public long length() {
        return string.length();
    }

    /**
     * Closing stream.
     * @throws IReaderException reader exception.
     */
    public void close() throws IReaderException {

    }
}
