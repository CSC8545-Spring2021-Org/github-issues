package edu.studio.issue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;
import java.util.List;

public class IssueExporter {

    protected static final String ERROR_MESSAGE = "Make sure you are providing only one non empty and non null argument!";
    protected static final String ACTUAL_FILE_PATH = "actual-issues.txt";

    public static void main(String[] args) {
        
        IssueExporter exporter = new IssueExporter();
        
        if(!exporter.validatePat(args)) {
           exporter.printErrorMessage();
           exporter.exitSystem();
        }
        
        GitHubRestClient client = new GitHubRestClient();
        String jsonResponse = client.getIssuesFromGitHub(args[0]);
        
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(jsonResponse);
    }
    protected boolean validatePat(String[] args) {

        return (args == null || args[0] == null || args.length != 1 || args[0].isEmpty()) ? false : true;
    }

    protected void exitSystem() {
        printErrorMessage();
        System.exit(0);
    }

    protected void printErrorMessage() {

        System.out.println(ERROR_MESSAGE);
    }
    
    public void exportToFile(List<Issue> issues) throws FileNotFoundException, IOException, InvalidPathException {
       
        PrintWriter writer = new PrintWriter(ACTUAL_FILE_PATH);
        
        try {
            
            for ( Issue issue: issues) {
                writer.write(issue.toString());
            }
        }
        
        finally {
            writer.close();
        }
        
        
    }

}
