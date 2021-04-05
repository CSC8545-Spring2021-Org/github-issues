package edu.studio.issue;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class GitHubRestClient {

    private static final String TEST_AREA_URL = "https://api.github.com/repos/CSC8545-Spring2021-Org/issues-test-area-8545s21/issues?state=all";

    public String getIssuesFromGitHub(String token) {
        
        HttpResponse<String> response = Unirest.get(TEST_AREA_URL)
                .header("Authorization", "Bearer " + token).asString();
        
        return response.getStatus()==200?response.getBody():null;
    }

}
