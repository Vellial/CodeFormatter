package com.lightside.codeformatterproject.impl.strings;

import com.lightside.codeformatterproject.IWriter;
import com.lightside.codeformatterproject.IWriterException;

/**
 * String writer.
 */
public class StringWriter implements IWriter {

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
     * @throws IWriterException writer exception.
     */
    public void write(final String str) throws IWriterException {
        string.append(str);
    }

    /**
     * Getter for string.
     * @return string.
     */
    public String getString() {
        return string.toString();
    }

    /**
     * Closing stream.
     */
    public void close() {

    }
}
