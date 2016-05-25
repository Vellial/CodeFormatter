package com.lightside.codeformatterproject.codeformatter;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.settings.Settings;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Class for format code from file.
 */
public class CodeFormatter implements ICodeFormatter {

    private String lineBreak;
    private char offsetSymbol;
    private int offsetLength;

    /**
     * Doc
     * @param settings settings
     */
    public CodeFormatter(final Settings settings) {
        this.lineBreak = settings.getLineBreak();
        this.offsetSymbol = settings.getOffsetSymbol();
        this.offsetLength = settings.getOffsetLength();
    }

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
                        String s = str.toString();
                        writer.write(makeString(str.toString(), offsetLength * bracketcounter), 1);
                        writer.write(lineBreak, 1);
                        str.delete(0, str.length());
                        bracketcounter++;
                        break;
                    case ';':
                        writer.write(makeString(str.toString(), offsetLength * bracketcounter), 1);
                        writer.write(lineBreak, 1);
                        str.delete(0, str.length());
                        break;
                    case '}':
                        int repeat = (offsetLength * bracketcounter) + (offsetLength * -1);
                        writer.write(makeString(str.toString(), repeat), 1);
                        writer.write(lineBreak, 1);
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
            Arrays.fill(array, offsetSymbol);
            String offsetStr = new String(array);
            return offsetStr + str.trim();
        } catch (NegativeArraySizeException e) {
            throw new NegativeArraySizeException();
        }
    }

}
