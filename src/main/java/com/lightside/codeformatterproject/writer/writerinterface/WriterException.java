package com.lightside.codeformatterproject.writer.writerinterface;

/**
 * Writer exception for writer.
 */
public class WriterException extends Exception {
    /**
     * Writer exception.
     * @param e exception.
     */
    public WriterException(final Exception e) {
        super(e);
    }
}
