package com.lightside.codeformatterproject;

import com.lightside.codeformatterproject.impl.CodeFormatter;
import com.lightside.codeformatterproject.impl.filestreams.FileReader;
import com.lightside.codeformatterproject.impl.filestreams.FileWriter;
import com.lightside.codeformatterproject.impl.strings.StringReader;
import com.lightside.codeformatterproject.impl.strings.StringWriter;

import java.io.File;

/**
 * Main class for Code CodeFormatter
 */
public class Main {

    /**
     * Main method for code CodeFormatter.
     * @param args string args.
     * @throws ICodeFormatterException exception.
     */
    public static void main(final String[] args) throws ICodeFormatterException {

        // Formatting file with code.
        File dir = new File("./src/main/resources");
        File file = new File(dir, "readfile"); // file for reading.
        File writeFile = new File("./src/main/resources/writefile"); // file for writing.
        try {
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(writeFile);
            CodeFormatter codeFormatter = new CodeFormatter();
            codeFormatter.formatCode(fileReader, fileWriter);
            fileReader.close();
            fileWriter.close();

            // Formatting string with code.
            String code = "while(x<3){int i = 0; i=i+x; System.out.println(i);}";
            StringReader strReader = new StringReader(code);
            StringWriter strWriter = new StringWriter();
            codeFormatter.formatCode(strReader, strWriter);
            String result = strWriter.getString();
            System.out.println(result);
        } catch (Exception e) {
            throw new ICodeFormatterException("Code Formatter Error", e);
        }

    }

}
