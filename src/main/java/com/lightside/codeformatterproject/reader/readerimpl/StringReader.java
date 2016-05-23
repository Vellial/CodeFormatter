package com.lightside.codeformatterproject.reader.readerimpl;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;

/**
 * Class for reading from string.
 */
public class StringReader implements IReader {
    private char[] chars;
    private int index;

    /**
     * Constructor.
     * @param str string for reading.
     */
    public StringReader(final String str) {
        chars = str.toCharArray();
        index = 0;
    }

    /**
     * Get symbol index.
     * @return index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Read symbol from string.
     * @return char symbol from string.
     * @throws ReaderException reader exception.
     */
    public char read() throws ReaderException {
        char cursymbol = chars[index];
        index++;
        return cursymbol;
    }

    /**
     * Get hasNext for string.
     * @return hasNext.
     */
    public boolean hasNext() {
        boolean hasNext = true;
        if (chars.length <= index) {
            hasNext = false;
        }
        return hasNext;
    }

}
