package com.lightside.codeformatterproject.writer;

import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.writer.writerimpl.FileWriter;
import com.lightside.codeformatterproject.writer.writerimpl.StringWriter;
import com.lightside.codeformatterproject.writer.writerinterface.WriterException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for writer.
 */
public class writerTest {

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
    public void writeStrTest() throws WriterException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("test", 1);
        assertEquals(stringWriter.getString(), "test");
    }
}
