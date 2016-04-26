package com.lightside.codeformatterproject.codeformatter;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;

/**
 * Class for format code from file.
 */
public class CodeFormatter implements ICodeFormatter {

    private static final String ENTER = "\n";
    private static final String SPACE = " ";
    private static final int REPEAT = 4;

    /**
     * Method for format code
     * @param reader reader thread with symbol reading.
     * @param writer writer thread for writing symbols.
     * @throws CodeFormatterException code formatter exception
     */
    public void formatCode(final IReader reader, final IWriter writer) throws CodeFormatterException {
        int bracketcounter = 0;
        try {
            while (reader.hasNext()) { // todo if hasNext
                char symbol = reader.read();
                switch (symbol) {
                    case '{':
                        bracketcounter++;
                        writer.write(symbol + ENTER, 1);
                        writer.write(SPACE, REPEAT * bracketcounter);
                        break;
                    case ';':
                        writer.write(symbol + ENTER, 1);
                        writer.write(SPACE, REPEAT * bracketcounter);
                        break;
                    case '}':
                        writer.write(symbol + ENTER, 1);
                        break;
                    default:
                        writer.write("" + symbol, 1);
                        break;
                }
            }
        } catch (Exception e) {
            throw new CodeFormatterException(e);
        }
    }

}
