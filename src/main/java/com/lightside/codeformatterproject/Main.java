package com.lightside.codeformatterproject;

import com.lightside.codeformatterproject.codeformatter.CodeFormatter;
import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.settings.Settings;
import com.lightside.codeformatterproject.writer.writerimpl.FileWriter;
import com.lightside.codeformatterproject.reader.readerimpl.StringReader;
import com.lightside.codeformatterproject.writer.writerimpl.StringWriter;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Main class for Code codeformatter
 */
public class Main {

    /**
     * Main method for code codeformatter.
     * @param args string args.
     */
    public static void main(final String[] args) {
        final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

        // Formatting file with code.
        logger.info("Application started");

        File dir = new File("./src/main/resources");

        // reading settings from file.
        File settings = new File(dir, "settings");
        Settings fileSettings;

        File file = new File(dir, "readfile"); // file for reading.
        File writeFile = new File("./src/main/resources/writefile"); // file for writing.
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(settings));
            fileSettings = new Settings(props);
            
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(writeFile);
            CodeFormatter codeFormatter = new CodeFormatter(fileSettings);
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
        }

    }

}
