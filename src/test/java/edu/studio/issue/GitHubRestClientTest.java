package edu.studio.issue;

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
        
        
    }

}
