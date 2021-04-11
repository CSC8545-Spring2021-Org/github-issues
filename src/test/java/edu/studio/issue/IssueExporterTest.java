package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IssueExporterTest {

    private IssueExporter export;

    @BeforeEach
    void setUp() throws Exception {
        export = new IssueExporter();
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

}
