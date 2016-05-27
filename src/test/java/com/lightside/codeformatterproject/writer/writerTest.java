package com.lightside.codeformatterproject.writer;

import com.lightside.codeformatterproject.reader.readerinterface.ReaderException;
import com.lightside.codeformatterproject.writer.writerimpl.FileWriter;
import com.lightside.codeformatterproject.writer.writerimpl.StringWriter;
import com.lightside.codeformatterproject.writer.writerinterface.IWriter;
import com.lightside.codeformatterproject.writer.writerinterface.WriterException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for writer.
 */
public class writerTest {

    //File writer
    @Test
    public void writeFileTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException, ReaderException {
        IWriter mockWriter = mock(IWriter.class);
        mockWriter.write("test", 1);
        when(mockWriter.getString()).thenReturn("test");
        assertEquals(mockWriter.getString(), "test");
    }

    @Test
    public void getStringFileTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException, ReaderException {
        IWriter mockWriter = mock(IWriter.class);
        when(mockWriter.getString()).thenReturn("test");
        assertEquals(mockWriter.getString(), "test");
    }

    @Test(expected = WriterException.class)
    public void writeFileErrTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException {
        IWriter mockWriter = mock(IWriter.class);
        doThrow(WriterException.class).when(mockWriter).write("w", 2);
        mockWriter.write("w", 2);
        fail();
        }

    @Test
    public void closeTest() throws FileNotFoundException, UnsupportedEncodingException, WriterException {
        FileWriter fileWriter = new FileWriter(new File("test"));
        fileWriter.close();
    }

    // String writer.
    @Test
    public void writeStrTest() throws WriterException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("test", 1);
        assertEquals(stringWriter.getString(), "test");
    }
}
