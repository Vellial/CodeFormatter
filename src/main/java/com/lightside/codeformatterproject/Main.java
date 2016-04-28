package com.lightside.codeformatterproject;

import com.lightside.codeformatterproject.codeformatter.CodeFormatter;
import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.writer.writerimpl.FileWriter;
import com.lightside.codeformatterproject.reader.readerimpl.StringReader;
import com.lightside.codeformatterproject.writer.writerimpl.StringWriter;
import org.slf4j.LoggerFactory;

import java.io.File;
/**
 * Main class for Code codeformatter
 */
public class Main {

    /**
     * Main method for code codeformatter.
     * @param args string args.
     * //@throws CodeFormatterException exception.
     */
    public static void main(final String[] args) {
        final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

        // Formatting file with code.
        logger.info("Application started");
        File dir = new File("./src/main/resources");
        File file = new File(dir, "readfile"); // file for reading.
        File writeFile = new File("./src/main/resources/writefile"); // file for writing.
        try {
            FileReader fileReader = new FileReader(file); // todo add logger here
            FileWriter fileWriter = new FileWriter(writeFile);
            CodeFormatter codeFormatter = new CodeFormatter();
            codeFormatter.formatCode(fileReader, fileWriter);
            fileReader.close();
            fileWriter.close();

            // Formatting string with code.
            String code = "while(x<3){int i = 0;i=i+x;System.out.println(i);if(x < 2) {System.out.println(\"Hohoho\");while (x) {int t = 0;int m = 1;int n = m + t;}}}";
            StringReader strReader = new StringReader(code);
            StringWriter strWriter = new StringWriter();
            codeFormatter.formatCode(strReader, strWriter);
            String result = strWriter.getString();
            System.out.println(result);
        } catch (Exception e) {
            logger.error("Fatal error", e);
//            throw new CodeFormatterException(e);
        }

    }

}
