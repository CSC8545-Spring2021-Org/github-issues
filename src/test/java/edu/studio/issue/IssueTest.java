package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IssueTest {
    
    private Issue issue;
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        issue = new Issue();
        user = new User();
    }

    @Test
    public void testProperties() {
      
        
        issue.setId(42);
        assertEquals(42, issue.getId());
        
        issue.setNumber(42);
        assertEquals(42, issue.getNumber());
        
        issue.setState("open");
        assertEquals("open", issue.getState());
        
        issue.setTitle("Issue 1");
        assertEquals("Issue 1", issue.getTitle());
        
        issue.setBody("This is the first issue.");
        assertEquals("This is the first issue.", issue.getBody());
        
        Date expectedDate = new Date();
        issue.setCreatedAt(expectedDate);
        assertEquals(expectedDate, issue.getCreatedAt());
        
        assertEquals(null, issue.getClosedAt());
        
        issue.setAssignee(user);
        assertEquals(user, issue.getAssignee());
        
        issue.setUser(user);
        assertEquals(user, issue.getUser());
    }
    
    @Test
    public void testToStringEmpty() {
        
        assertEquals("Id: 0\nNumber: 0\nState: null\nTitle: null\nBody: null\nCreated At: null\nClosed At: null\n"
                + "User: null\nAssignee: null", issue.toString());
        
    }

}
