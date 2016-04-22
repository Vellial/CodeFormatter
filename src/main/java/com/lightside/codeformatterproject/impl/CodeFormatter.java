package com.lightside.codeformatterproject.impl;

import com.lightside.codeformatterproject.*;

/**
 * Class for format code from file.
 */
public class CodeFormatter implements ICodeFormatter {

    /**
     * Method for format code
     * @param reader reader thread with symbol reading.
     * @param writer writer thread for writing symbols.
     * @throws IReaderException reader exception
     * @throws IWriterException writer exception
     */
    public void formatCode(final IReader reader, final IWriter writer) throws IReaderException, IWriterException {
        int length = (int) reader.length();
        for (int i = 0; i < length; i++) {
            char symbol = reader.read();
            switch (symbol) {
                case '{':
                    writer.write(symbol + "\n    ");
                    break;
                case ';':
                    writer.write(symbol + "\n   ");
                    break;
                case '}':
                    writer.write(symbol + "\n");
                    break;
                default:
                    writer.write("" + symbol);
                    break;
            }
        }
    }

}
