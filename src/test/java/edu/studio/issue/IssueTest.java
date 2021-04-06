package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
    
    @Test
    public void testToStringPartial() {
        
        issue.setId(123456);
        issue.setTitle("First Issue");
        
        user.setId(123);
        user.setLogin("Utsav");
        issue.setUser(user);
        
        Date date= new Date();
        issue.setCreatedAt(date);
        

        assertEquals("Id: 123456\nNumber: 0\nState: null\nTitle: First Issue\nBody: null\nCreated At: " + date +"\nClosed At: null\n"
                + "User: Username: Utsav, Id: 123\nAssignee: null", issue.toString());
        
    }
    
    @Test
    public void testToStringFull() {
        
        issue.setId(123456);
        issue.setTitle("First Issue");
        issue.setBody("This describes the issue!");
        issue.setNumber(123);
        issue.setState("open");
        
        user.setId(123);
        user.setLogin("Utsav");
        issue.setUser(user);
        issue.setAssignee(user);
        
        Date date= new Date();
        issue.setCreatedAt(date);
        issue.setClosedAt(date);
        

        assertEquals("Id: 123456\nNumber: 123\nState: open\nTitle: First Issue\nBody: This describes the issue!\nCreated At: " + date +"\nClosed At: "+ date 
                +  "\nUser: Username: Utsav, Id: 123\nAssignee: Username: Utsav, Id: 123", issue.toString());
        
    }
    
    @Test
    public void testEqualsReferenceEquality() {
        Issue issue1 = new Issue();
        Issue issue2 = issue1;
        assertSame(issue1, issue2); //reference equality ==
    }

}
