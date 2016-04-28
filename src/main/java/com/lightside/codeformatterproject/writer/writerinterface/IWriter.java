package com.lightside.codeformatterproject.writer.writerinterface;

/**
 * Interface for writing symbols to strings and files.
 */
public interface IWriter {
    /**
     * Method for writing new symbols to stirng.
     * @param str string for writing.
     * @param repeat int number of repeating.
     * @throws WriterException writer exception.
     */
    void write(String str, int repeat) throws WriterException;
}
