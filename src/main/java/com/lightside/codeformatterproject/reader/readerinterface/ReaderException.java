package com.lightside.codeformatterproject.reader.readerinterface;

/**
 * Reader exception for reader.
 */
public class ReaderException extends Exception {
    /**
     * Reader exception.
     * @param e exception.
     */
    public ReaderException(final Exception e) {
        super(e);
    }
}
