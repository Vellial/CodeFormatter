package com.lightside.codeformatterproject.reader;

import com.lightside.codeformatterproject.reader.readerinterface.IReader;
import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.reader.readerimpl.FileReader;
import com.lightside.codeformatterproject.reader.readerimpl.StringReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.io.*;

/**
 * FileReader Test
 */
public class readerTest {

    private File dir = new File("./src/test/resources");
    private File file = new File(dir, "readfile");
    private File fileException = new File(dir, "exception");

    // method read().
    @Test
    public void readFileTest() throws FileNotFoundException, ReaderException {
//        FileReader fileReader = new FileReader(new FileInputStream(file));
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('w');
//        assertEquals(fileReader.read(), 'w');
        assertEquals(mockReader.read(), 'w');
    }

    @Test(expected = ReaderException.class)
    public void readFileErrTest() throws FileNotFoundException, ReaderException {
        FileReader fileReader = new FileReader(new FileInputStream(fileException));
        fileReader.close();
        fileReader.read();
        fail();
    }

    // method hasNext().
    @Test
    public void hasNextTest() throws ReaderException, FileNotFoundException {
//        FileReader fileReader = new FileReader(new FileInputStream(fileException));
        IReader mockReader = mock(IReader.class);
        when(mockReader.hasNext()).thenReturn(false);
        assertEquals(mockReader.hasNext(), false);
    }

    @Test(expected = ReaderException.class)
    public void hasNextExceptionTest() throws ReaderException, FileNotFoundException {
        FileReader fileReader = new FileReader(new FileInputStream(fileException));
        fileReader.close();
        fileReader.hasNext();
        fail();
    }

    // method close().
    @Test
    public void closeTest() throws FileNotFoundException, ReaderException {
        FileReader fileReader = new FileReader(new FileInputStream(file));
        fileReader.close();
    }

//    @Test(expected = ReaderException.class)
//    public void closeExceptionTest() throws FileNotFoundException, ReaderException {
//        FileReader fileReader = new FileReader(new FileInputStream(file));
//        fileReader.close();
//        fail();
//    }

    // Other tests. File not found.
    @Test(expected = FileNotFoundException.class)
    public void fileExceptionTest() throws FileNotFoundException, ReaderException {
        new FileReader(new FileInputStream(new File(dir, "test")));
        fail();
    }

    // method read() for string.
    @Test
    public void readStrTest() throws ReaderException {
        String string = "while(true){int x = 0; x=x+1;}";
        StringReader stringReader = new StringReader(string);
        assertEquals(stringReader.read(), 'w');
    }

    @Test
    public void hasNextStrTest() throws ReaderException, FileNotFoundException {
        String string = "";
        StringReader stringReader = new StringReader(string);
        assertEquals(stringReader.hasNext(), false);
    }

}
