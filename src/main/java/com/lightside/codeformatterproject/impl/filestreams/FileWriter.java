package com.lightside.codeformatterproject.impl.filestreams;

import com.lightside.codeformatterproject.IWriter;
import com.lightside.codeformatterproject.IWriterException;

import java.io.*;

/**
 * Class for writing to file.
 */
public class FileWriter implements IWriter {

    private Writer writer;

    /**
     * Constructor.
     * @param file file.
     * @throws FileNotFoundException exception - file not found
     * @throws UnsupportedEncodingException exception unsupported encoding
     */
    public FileWriter(final File file) throws FileNotFoundException, UnsupportedEncodingException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        writer = new OutputStreamWriter(fileOutputStream, "utf-8");
    }

    /**
     * Write to string or file new symbols
     * @param str string for writing
     * @throws IWriterException exception
     */
    public void write(final String str) throws IWriterException {
        try {
            writer.write(str);
            writer.flush();
        } catch (Exception e) {
            throw new IWriterException("Writer Exception", e);
        }
    }

    /**
     * Closing stream.
     * @throws IWriterException writer exception.
     */
    public void close() throws IWriterException {
        try {
            writer.close();
        } catch (Exception e) {
            throw new IWriterException("Close Writer Error", e);
        }
    }
}
