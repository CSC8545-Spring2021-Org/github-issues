package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GitHubRestClientTest {

    private GitHubRestClient client;
    @BeforeEach
    void setUp() throws Exception {
        
        client = new GitHubRestClient();
    }

    @Test
    void returnsIssuesFromGitHub() {
        
        String token = System.getProperty("bearer.token"); 
        assertNotNull(token);
        assertTrue(token.length() > 0);
        
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/sample-output.txt")); 
        assertNotNull(expectedJson);
        assertTrue(expectedJson.length() > 0);
        
        String actualJson = client.getIssuesFromGitHub(token);
        assertEquals(expectedJson, actualJson);
        
    }

}
