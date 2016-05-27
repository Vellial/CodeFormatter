package com.lightside.codeformatterproject.writer.writerimpl;

import com.lightside.codeformatterproject.writer.writerinterface.IWriter;
import com.lightside.codeformatterproject.writer.writerinterface.WriterException;

import java.io.*;

/**
 * Class for writing to file.
 */
public class FileWriter implements IWriter {

    private Writer writer;
    private StringBuilder string;

    /**
     * Constructor.
     * @param file file.
     * @throws FileNotFoundException exception - file not found
     * @throws UnsupportedEncodingException exception unsupported encoding
     */
    public FileWriter(final File file) throws FileNotFoundException, UnsupportedEncodingException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        writer = new OutputStreamWriter(fileOutputStream, "utf-8");
        string = new StringBuilder();
    }

    /**
     * Write to string or file new symbols.
     * @param str string for writing.
     * @param repeat int quantity of repeating.
     * @throws WriterException exception.
     */
    public void write(final String str, final int repeat) throws WriterException {
        int i = repeat;
        try {
            while (i > 0) {
                string.append(str);
                writer.write(str);
                i--;
            }
            writer.flush();
        } catch (Exception e) {
            throw new WriterException(e);
        }
    }

    /**
     * Method for getting wrote string.
     * @return string wrote string.
     */
    public String getString() {
        return string.toString();
    }

    /**
     * Closing stream.
     * @throws WriterException writer exception.
     */
    public void close() throws WriterException {
        try {
            writer.close();
        } catch (Exception e) {
            throw new WriterException(e);
        }
    }

}
