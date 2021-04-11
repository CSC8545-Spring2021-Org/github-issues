package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IssueParserTest {

    private IssueParser parser;
    @BeforeEach
    void setUp() throws Exception {
        parser= new IssueParser();
    }

    @Test
    void testParseIssueWithValidJson() throws IOException{
        parser = new IssueParser();
        String json = Files.readString(
                Paths.get("src/test/resources/sample-output.txt")); 
        User user = new User();
        user.setId(55940428);
        user.setLogin("W2NJL");
        
        List<Issue> issues = parser.parseIssues(json);
        assertNotNull(issues);
        assertEquals(7, issues.size());  
        
        Issue issue0 = issues.get(0);
        assertEquals(851747305, issue0.getId());
        assertEquals(7, issue0.getNumber());
        assertEquals("open", issue0.getState());
        assertEquals("Testing!", issue0.getTitle());
        assertEquals(null, issue0.getBody());
        assertEquals(user, issue0.getUser());
        
        

    }

}
