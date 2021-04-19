package edu.studio.issue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class IssueExporter {

    protected static final String FAILED_TO_WRITE_TO_FILE = "Failed to write to file!";
    protected static final String ERROR_MESSAGE = "Make sure you are providing only one non empty and non null argument!";
    protected static final String ACTUAL_FILE_PATH = "actual-issues.txt";

    public static void main(String[] args) {

        IssueExporter exporter = new IssueExporter();

        exporter.export(args);
        
    }

    protected void export(String[] args) {

        if (!validatePat(args)) {
            printErrorMessage();
            exitSystem();
        }

        RestClient client = new GitHubRestClient();
        String jsonResponse = getJsonResponse(args, client);

        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(jsonResponse);

        exportToFile(issues, ACTUAL_FILE_PATH);

    }

    protected String getJsonResponse(String[] args, RestClient client) {
        String jsonResponse = client.getIssuesFromGitHub(args[0]);
        return jsonResponse;
    }

    protected boolean validatePat(String[] args) {

        return (args == null || args[0] == null || args.length != 1 || args[0].isEmpty()) ? false : true;
    }

    protected void exitSystem() {
        System.exit(0);
    }

    protected void printErrorMessage() {

        System.out.println(ERROR_MESSAGE);
    }

    public void exportToFile(List<Issue> issues, String filePath) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
            for (Issue issue : issues) {
                writer.write(issue.toString() + "\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.print(FAILED_TO_WRITE_TO_FILE);
        }
        finally {
            if (writer != null) {
                writer.close();
            }

        }

    }

}
