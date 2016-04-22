package com.lightside.codeformatterproject;

/**
 * Interface for code formatting.
 */
public interface ICodeFormatter {
    /**
     * Method for code formatting
     * @param reader Input stream.
     * @param writer Output stream.
     * @throws IReaderException reader exceptions.
     * @throws IWriterException writer exceptions.
     */
    void formatCode(IReader reader, IWriter writer) throws IReaderException, IWriterException;
}
