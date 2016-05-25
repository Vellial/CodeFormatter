package com.lightside.codeformatterproject.reader.readerimpl;

import com.lightside.codeformatterproject.additional.IClosable;
import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Read from URL
 */
public class URLReader implements IReader, IClosable {
    private InputStream in;

    /**
     * Constructor
     * @param url url to code for formatting.
     * @throws IOException exception.
     */
    public URLReader(final String url) throws IOException {
        URL httpUrl = new URL(url);
        URLConnection connection = httpUrl.openConnection();
        in = connection.getInputStream();
    }

    /**
     * Read symbol from URL
     * @return char symbol.
     * @throws ReaderException reader exception
     */
    public char read() throws ReaderException {
        try {
            return (char) in.read();
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

    /**
     * Checks next symbol in stream.
     * @return boolean has next or not.
     * @throws ReaderException reader exception
     */
    public boolean hasNext() throws ReaderException {
        boolean hasNext = true;
        try {
            if (in.available() <= 0) {
                hasNext = false;
            }
            return hasNext;
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

    /**
     * Close stream.
     * @throws ReaderException exception.
     */
    public void close() throws ReaderException {
        try {
            in.close();
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }
}
