package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

class GitHubRestClientMockTest {

    private Mockery context = new Mockery();


    @Test
    void testGetJsonResponse() throws IOException {
        
       
        IssueExporter exporter = new IssueExporter();
        String[] token = new String[] {System.getProperty("bearer.token")};
        final RestClient client = context.mock(RestClient.class);
        context.checking(new Expectations() {
            {
        

                oneOf(client).getIssuesFromGitHub(with(token[0]));
                will(returnValue(Files.readString(Paths.get("src/test/resources/sample-output.txt"))));

            }
            
        });
            
            String actualResult = exporter.getJsonResponse(token, client);
            
            context.assertIsSatisfied();
            
            assertEquals(Files.readString(Paths.get("src/test/resources/sample-output.txt")), actualResult);
       
        
        
        
    }
    @Test
    void testGetJsonResponseInvalidTokenGivesNull() throws IOException {
        
       
        IssueExporter exporter = new IssueExporter();
        String[] token = new String[] {"invalidtoken1213"};
        final RestClient client = context.mock(RestClient.class);
        context.checking(new Expectations() {
            {
        

                oneOf(client).getIssuesFromGitHub(with(token[0]));
                will(returnValue(null));

            }
            
        });
            
            String actualResult = exporter.getJsonResponse(token, client);
            
            context.assertIsSatisfied();
            
            assertEquals(null, actualResult);
       
        
        
        
    }

}
