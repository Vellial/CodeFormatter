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
     */
    boolean hasNext() throws ReaderException; // todo hasNext

    /**
     * Method for closing thread.
     * @throws ReaderException reader exception.
     */
    void close() throws ReaderException;
}
