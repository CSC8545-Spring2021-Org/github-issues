package edu.studio.issue;

public class IssueExporter {

    protected boolean validatePat(String[] args) {
        
        return (!(args==null) && args.length==1 && !args[0].isEmpty() 
                && !(args[0]==null)) ? true : false;
    }

}
