package com.lightside.codeformatterproject.reader.readerimpl;

import com.lightside.codeformatterproject.additional.IClosable;
import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;

import java.io.*;

/**
 * Class for reading from file.
 * todo additional interface
 */
public class FileReader implements IReader, IClosable {

    private InputStream fileInputStream;

    /**
     * Constructor.
     * @param file file to read.
     * @throws FileNotFoundException exception.
     */
    public FileReader(final File file) throws FileNotFoundException {
        fileInputStream = new BufferedInputStream(new FileInputStream(file));
    }

    /**
     * Method for reading symbols from file.
     * @return char symbol.
     * @throws ReaderException reader exception.
     */
    public char read() throws ReaderException {
        try {
            return (char) fileInputStream.read();
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

    /**
     * Get hasNext of file.
     * @return hasNext.
     * @throws ReaderException reader exception.
     */
    public boolean hasNext() throws ReaderException {
        boolean hasNext = true;
        try {
            if (fileInputStream.read() < 0) {
                hasNext = false;
            }
            return hasNext;
        } catch (Exception e) {
            throw new ReaderException(e);
        }

    }

    /**
     * Closing stream.
     * @throws ReaderException reader exception.
     */
    public void close() throws ReaderException {
        try {
            fileInputStream.close();
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

}
