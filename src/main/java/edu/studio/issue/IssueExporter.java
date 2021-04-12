package edu.studio.issue;

public class IssueExporter {

    public static final String ERROR_MESSAGE = "Make sure you are providing only one non empty and non null argument!";

    protected boolean validatePat(String[] args) {

        return (args == null || args[0] == null || args.length != 1 || args[0].isEmpty()) ? false : true;
    }

}
