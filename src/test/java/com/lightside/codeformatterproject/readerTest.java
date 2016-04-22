package com.lightside.codeformatterproject;

import com.lightside.codeformatterproject.impl.filestreams.FileReader;
import com.lightside.codeformatterproject.impl.filestreams.FileWriter;
import com.lightside.codeformatterproject.impl.strings.StringReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.lightside.codeformatterproject.impl.strings.StringWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * FileReader Test
 */
public class readerTest {

    @Test
    public void readFileTest() throws FileNotFoundException, IReaderException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "readfile");
        FileReader fileReader = new FileReader(file);
        assertEquals(fileReader.read(), 'w');
    }

    @Test(expected = IReaderException.class)
    public void readFileErrTest() throws FileNotFoundException, IReaderException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "exception");
        FileReader fileReader = new FileReader(file);
        fileReader.read();
        fail();
//        assertEquals(fileReader.read(), 'w');
    }

    @Test(expected = IWriterException.class)
    public void writeFileErrTest() throws FileNotFoundException, UnsupportedEncodingException, IWriterException, IReaderException {
        File writeFile = new File("./src/test/resources/exception");
        FileWriter fileWriter = new FileWriter(writeFile);
        fileWriter.write("");
        fail();
    }

    @Test
    public void writeFileTest() throws FileNotFoundException, UnsupportedEncodingException, IWriterException, IReaderException {
        File writeFile = new File("./src/test/resources/writefile");
        FileWriter fileWriter = new FileWriter(writeFile);
        fileWriter.write("test");
        FileReader fReader = new FileReader(writeFile);
        char[] chars = new char[(int) fReader.length()];
        for (int i = 0; i < fReader.length(); i++) {
            chars[i] = fReader.read();
        }
        String newStr = new String(chars);
        assertEquals(newStr, "test");
    }

    @Test
    public void readStrTest() throws IReaderException {
        String string = "while(true){int x = 0; x=x+1;}";
        StringReader stringReader = new StringReader(string);
        assertEquals(stringReader.read(), 'w');
    }

    @Test
    public void writeStrTest() throws IWriterException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("test");
        assertEquals(stringWriter.getString(), "test");
    }

}
