package com.lightside.codeformatterproject;

/**
 * Interface for writing symbols to strings and files.
 */
public interface IWriter {
    /**
     * Method for writing new symbols to stirng.
     * @param str string for writing.
     * @throws IWriterException writer exception.
     */
    void write(String str) throws IWriterException;

    /**
     * Method for closing thread.
     * @throws IWriterException writer exception.
     */
    void close() throws IWriterException;
}
