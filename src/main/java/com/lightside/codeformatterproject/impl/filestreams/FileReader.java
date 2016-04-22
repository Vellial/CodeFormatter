package com.lightside.codeformatterproject.impl.filestreams;

import com.lightside.codeformatterproject.IReader;
import com.lightside.codeformatterproject.IReaderException;

import java.io.*;

/**
 * Class for reading from file.
 */
public class FileReader implements IReader {

    private File file;
    private InputStream fileInputStream;

    /**
     * Constructor.
     * @param file file to read.
     * @throws FileNotFoundException exception.
     */
    public FileReader(final File file) throws FileNotFoundException {
        this.file = file;
        fileInputStream = new FileInputStream(file);
    }

    /**
     * Method for reading symbols from file.
     * @return char symbol.
     * @throws IReaderException reader exception.
     */
    public char read() throws IReaderException {
        try {
            return (char) fileInputStream.read();
        } catch (Exception e) {
            throw new IReaderException("Reader Error", e);
        }
    }

    /**
     * Get length of file.
     * @return length.
     */
    public long length() {
        return file.length();
    }

    /**
     * Closing stream.
     * @throws IReaderException reader exception.
     */
    public void close() throws IReaderException {
        try {
            fileInputStream.close();
        } catch (Exception e) {
            throw new IReaderException("Closing Reader Exception", e);
        }
    }

}
