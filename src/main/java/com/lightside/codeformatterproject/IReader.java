package com.lightside.codeformatterproject;

import java.io.File;
import java.io.IOException;

/**
 * Interface for reading files and strings
 */
public interface IReader {
    /**
     * Method for reading from file or string,
     * @return symbol.
     * @throws IReaderException exception.
     */
    char read() throws IReaderException;

    /**
     * Get length.
     * @return length.
     */
    long length();

    /**
     * Method for closing thread.
     * @throws IReaderException reader exception.
     */
    void close() throws IReaderException;
}
