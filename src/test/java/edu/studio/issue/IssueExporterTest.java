package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
    void testExportToFileHandleFileNotFoundException() {

        List<Issue> issues = new ArrayList<Issue>();
        Issue issue = new Issue();
        issue.setId(123456);
        issue.setTitle("First Issue");
        issue.setBody("This describes the issue!");

        issues.add(issue);

        System.setOut(outputNet);
        export.exportToFile(issues, "src/bla/actual-issues.txt");
        String expectedOutput = IssueExporter.FAILED_TO_WRITE_TO_FILE;
        assertEquals(expectedOutput, byteStream.toString());
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
