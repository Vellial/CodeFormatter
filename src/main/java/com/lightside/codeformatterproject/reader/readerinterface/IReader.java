package com.lightside.codeformatterproject.reader.readerinterface;

/**
 * Interface for reading files and strings
 */
public interface IReader {
    /**
     * Method for reading from file or string,
     * @return symbol.
     * @throws ReaderException exception.
     */
    char read() throws ReaderException;

    /**
     * Get hasNext.
     * @return hasNext.
     * @throws ReaderException exception.
     */
    boolean hasNext() throws ReaderException;
}
