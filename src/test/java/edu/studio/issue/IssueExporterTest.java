package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;

class IssueExporterTest {

    private IssueExporter export;
    private ByteArrayOutputStream byteStream;
    private PrintStream outputNet;
    private static String separator = System.lineSeparator();

    @BeforeEach
    void setUp() throws Exception {
        export = new IssueExporter();
        byteStream = new ByteArrayOutputStream();
        outputNet = new PrintStream(byteStream);
    }

    @Test
    void testValidPatGivesTrue() {

        String[] args = new String[] { "ghjksdfkksdf215465sf" };

        boolean actual = export.validatePat(args);

        assertEquals(true, actual);

    }

    @Test
    void testNullArrayGivesFalse() {

        String[] args = null;

        boolean actual = export.validatePat(args);

        assertEquals(false, actual);

    }

    @Test
    void testNullStringGivesFalse() {

        String[] args = new String[] { null };

        boolean actual = export.validatePat(args);

        assertEquals(false, actual);

    }
    
    @Test
    void testMultipleStringGivesFalse() {

        String[] args = new String[] { "4554fsfs557fd", "44sdf478re1" };

        boolean actual = export.validatePat(args);

        assertEquals(false, actual);

    }
    
    @Test
    void testEmptyStringGivesFalse() {

        String[] args = new String[] { "" };

        boolean actual = export.validatePat(args);

        assertEquals(false, actual);

    }

    @Test
    void testPrintErrorMessage() {
        System.setOut(outputNet);
        export.printErrorMessage();
        String expectedOutput = IssueExporter.ERROR_MESSAGE + separator;
        assertEquals(expectedOutput, byteStream.toString());
    }
    
    @Test
    @ExpectSystemExitWithStatus(0)
    void testSystemExitOnInvalidPat() {
        export.exitSystem();

    }

}
