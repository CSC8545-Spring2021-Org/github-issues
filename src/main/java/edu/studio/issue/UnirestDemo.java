package edu.studio.issue;

import kong.unirest.Unirest;

public class UnirestDemo {

    protected static final String TEST_AREA_URL = "https://api.github.com/repos/CSC8545-Spring2021-Org/github-issues-8545-s21-uphunyal/issues?state=all";

    public static void main(String[] args) {
        UnirestDemo demo = new UnirestDemo();

        demo.requestViaBearerToken(args);
    }

    protected void requestViaBearerToken(String[] args) {
        String responseBody = Unirest.get(TEST_AREA_URL).header("Authorization", "Bearer " + args[0]).asString()
                .getBody();

        System.out.println(responseBody);
    }

}
