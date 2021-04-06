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
        
        issue.setState("open");
        assertEquals("open", issue.getState());
        
        issue.setTitle("Issue 1");
        assertEquals("Issue 1", issue.getTitle());
        
        issue.setBody("This is the first issue.");
        assertEquals("This is the first issue.", issue.getBody());
        
        Date expectedDate = new Date();
        issue.setCreatedAt(expectedDate);
        assertEquals(expectedDate, issue.getCreatedAt());
        
        issue.setClosedAt(expectedDate);
        assertEquals(expectedDate, issue.getClosedAt());
        
        issue.setAssignee(user);
        assertEquals(user, issue.getAssignee());
        
        issue.setUser(user);
        assertEquals(user, issue.getUser());
    }

}
