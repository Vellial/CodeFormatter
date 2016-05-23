package com.lightside.codeformatterproject.codeformatter;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;

import java.util.Arrays;

/**
 * Class for format code from file.
 */
public class CodeFormatter implements ICodeFormatter {

    private static final String ENTER = "\n";
    private static final char SPACE = ' ';
    private static final int REPEAT = 4;

    /**
     * Method for format code
     * @param reader reader thread with symbol reading.
     * @param writer writer thread for writing symbols.
     * @throws CodeFormatterException code formatter exception
     */
    public void formatCode(final IReader reader, final IWriter writer) throws CodeFormatterException {
        int bracketcounter = 0;
        StringBuilder str = new StringBuilder();
        try {
            while (reader.hasNext()) {
                char symbol = reader.read();
                str.append(symbol);
                switch (symbol) {
                    case '{':
                        writer.write(makeString(str.toString(), REPEAT * bracketcounter), 1);
                        writer.write(ENTER, 1);
                        str.delete(0, str.length());
                        bracketcounter++;
                        break;
                    case ';':
                        writer.write(makeString(str.toString(), REPEAT * bracketcounter), 1);
                        writer.write(ENTER, 1);
                        str.delete(0, str.length());
                        break;
                    case '}':
                        int repeat = (REPEAT * bracketcounter) + (REPEAT * -1);
                        writer.write(makeString(str.toString(), repeat), 1);
                        writer.write(ENTER, 1);
                        str.delete(0, str.length());
                        bracketcounter--;
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            throw new CodeFormatterException(e);
        }
    }

    private String makeString(final String str, final int offset) throws NegativeArraySizeException {
        try {
            char[] array = new char[offset];
            Arrays.fill(array, SPACE);
            String offsetStr = new String(array);
            return offsetStr + str.trim();
        } catch (NegativeArraySizeException e) {
            throw new NegativeArraySizeException();
        }
    }

}
