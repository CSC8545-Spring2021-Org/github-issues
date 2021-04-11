package edu.studio.issue;

public class IssueExporter {

    protected boolean validatePat(String[] args) {

        return (args == null || args[0] == null || args.length != 1 || args[0].isEmpty()) ? false : true;
    }

}
