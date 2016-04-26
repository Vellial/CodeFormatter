package com.lightside.codeformatterproject;

import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.writer.writerinterface.WriterException;
import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.writer.writerimpl.FileWriter;
import com.lightside.codeformatterproject.reader.readerimpl.StringReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.lightside.codeformatterproject.writer.writerimpl.StringWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * FileReader Test
 */
public class readerTest {

    @Test
    public void readFileTest() throws FileNotFoundException, ReaderException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "readfile");
        FileReader fileReader = new FileReader(file);
        assertEquals(fileReader.read(), 'w');
    }

    @Test(expected = ReaderException.class)
    public void readFileErrTest() throws FileNotFoundException, ReaderException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "exception");
        FileReader fileReader = new FileReader(file);
        fileReader.read();
        fail();
    }

    @Test(expected = WriterException.class)
    public void writeFileErrTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException, ReaderException {
        File writeFile = new File("./src/test/resources/exception");
        FileWriter fileWriter = new FileWriter(writeFile);
        fileWriter.write("", 1);
        fail();
    }

    @Test
    public void writeFileTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException, ReaderException {
        File writeFile = new File("./src/test/resources/writefile");
        FileWriter fileWriter = new FileWriter(writeFile);
        fileWriter.write("test", 1);
        FileReader fReader = new FileReader(writeFile);
        char[] chars = new char[(int) writeFile.length()];
        int i = 0;
        while (fReader.hasNext()) {
            chars[i] = fReader.read();
            i++;
        }
        String newStr = new String(chars);
        assertEquals(newStr, "test");
    }

    @Test
    public void readStrTest() throws ReaderException {
        String string = "while(true){int x = 0; x=x+1;}";
        StringReader stringReader = new StringReader(string);
        assertEquals(stringReader.read(), 'w');
    }

    @Test
    public void writeStrTest() throws WriterException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("test", 1);
        assertEquals(stringWriter.getString(), "test");
    }

}
