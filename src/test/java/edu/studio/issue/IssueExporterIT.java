package edu.studio.issue;

import java.io.File;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Tests used from demo provided in class
public class IssueExporterIT {
    
    private IssueExporter exporter;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    @BeforeEach
    void setUp() {
        exporter=new IssueExporter();
    }
    
    @Test
    void testExportToFileWithNoIssuesGivesEmptyFule() {
        
        
        List<Issue> issues= getNoIssuesSample();
        exporter.exportToFile(issues);
        
        List<String> issueLines = readActualFile();
        assertNull(issueLines);
        assertTrue(issueLines.isEmpty());


        
    }

    private List<Issue> getNoIssuesSample() {
        
        return new ArrayList<Issue>();

    }
    
    private List<Issue> getThreeIssuesSample() throws ParseException {
        
        List<Issue> issues= new ArrayList<Issue>();
        
        Issue issue = new Issue();
        issue.setId(123456);
        issue.setTitle("First Issue");
        issue.setBody("This describes the issue!");
        issue.setNumber(123);
        issue.setState("open");
        issue.setUser(new User());
        issue.setAssignee(null);
        issue.setCreatedAt(dateFormat.parse("2021-04-06T19:30:10Z"));
        issue.setClosedAt(null);
        
        Issue issue1 = new Issue();
        issue1.setId(124);
        issue1.setTitle("Second Issue");
        issue1.setBody("This describes the second issue!");
        issue1.setNumber(125);
        issue1.setState("open");
        issue1.setUser(new User());
        
        Issue issue2 = new Issue();
        issue2.setId(68);
        issue2.setTitle("Third Issue");
        issue2.setBody("This describes the third issue!");
        issue2.setNumber(65);
        issue2.setState("closed");

        
        issues.add(issue1);
        issues.add(issue);
        issues.add(issue2);
        
        
        return issues;
    }
    
    private List<String> readActualFile(){
        
        return File.readAllLines(Paths.get(exporter.ACTUAL_FILE_PATH));
        
    }

}
