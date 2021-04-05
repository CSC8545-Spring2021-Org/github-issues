package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GitHubRestClientTest {

    private GitHubRestClient client;
    private String token;
    @BeforeEach
    void setUp() throws Exception {
        
        client = new GitHubRestClient();
        token = System.getProperty("bearer.token"); 
    }

    @Test
    void returnsIssuesFromGitHub() throws IOException {
        
        assertNotNull(token);
        assertTrue(token.length() > 0);
        
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/sample-output.txt")); 
        assertNotNull(expectedJson);
        assertTrue(expectedJson.length() > 0);
        
        String actualJson = client.getIssuesFromGitHub(token);
        assertEquals(expectedJson, actualJson);
        
    }
    
    @Test
    void returnsNullIfNot200() {
        
        //Invalid token to setup 401 response
        token="1230ahkk234jdfk";
        assertNotNull(token);
        assertTrue(token.length() > 0);
        
        String response = client.getIssuesFromGitHub(token);
        
        assertNull(response);
        
    }

}
