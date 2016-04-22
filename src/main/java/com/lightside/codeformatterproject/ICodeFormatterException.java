package com.lightside.codeformatterproject;

import java.io.IOException;

/**
 * Exception for CodeFormatter
 */
public class ICodeFormatterException extends Exception{

    /**
     * Constructor for exceptions
     * @param e throwable
     */
    public ICodeFormatterException(final String msg, final Exception e) {
        super(msg, e);
    }
}
