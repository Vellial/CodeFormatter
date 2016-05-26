package com.lightside.codeformatterproject.reader;

import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.reader.readerimpl.StringReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * FileReader Test
 */
public class readerTest {

    @Test
    public void readFileTest() throws FileNotFoundException, ReaderException, UnsupportedEncodingException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "readfile");
        FileReader fileReader = new FileReader(new FileInputStream(file));
        assertEquals(fileReader.read(), 'w');
    }

    @Test(expected = ReaderException.class)
    public void readFileErrTest() throws FileNotFoundException, ReaderException, UnsupportedEncodingException {
        File dir = new File("./src/test/resources");
        File file = new File(dir, "exception");
        FileReader fileReader = new FileReader(new FileInputStream(file));
        fileReader.read();
        fail();
    }

    @Test
    public void readStrTest() throws ReaderException {
        String string = "while(true){int x = 0; x=x+1;}";
        StringReader stringReader = new StringReader(string);
        assertEquals(stringReader.read(), 'w');
    }

}
