package com.lightside.codeformatterproject.codeformatter;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.writer.writerinterface.WriterException;

/**
 * Interface for code formatting.
 */
public interface ICodeFormatter {
    /**
     * Method for code formatting
     * @param reader Input stream.
     * @param writer Output stream.
     * @throws ReaderException reader exceptions.
     * @throws WriterException writer exceptions.
     */
    void formatCode(IReader reader, IWriter writer) throws CodeFormatterException;
}
