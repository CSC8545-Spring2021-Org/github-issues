package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IssueTest {

    private Issue issue;
    private Issue issue1;
    private Issue issue2;
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        issue = new Issue();
        user = new User();
        issue1 = new Issue();
        issue1.setId(42);
        issue2 = new Issue();
        issue2.setId(42);
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

        Date date = new Date();
        issue.setCreatedAt(date);

        assertEquals("Id: 123456\nNumber: 0\nState: null\nTitle: First Issue\nBody: null\nCreated At: " + date
                + "\nClosed At: null\n" + "User: Username: Utsav, Id: 123\nAssignee: null", issue.toString());

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

        Date date = new Date();
        issue.setCreatedAt(date);
        issue.setClosedAt(date);

        assertEquals(
                "Id: 123456\nNumber: 123\nState: open\nTitle: First Issue\nBody: This describes the issue!\nCreated At: "
                        + date + "\nClosed At: " + date
                        + "\nUser: Username: Utsav, Id: 123\nAssignee: Username: Utsav, Id: 123",
                issue.toString());

    }

    @Test
    public void testEqualsReferenceEquality() {

        issue2 = issue1;
        assertSame(issue1, issue2); // reference equality ==
    }

    @Test
    public void testEqualsValueEquality() {

        assertEquals(issue1, issue2); // value equality .equals()

        // equal objects must have equal hash codes
        assertEquals(issue1.hashCode(), issue2.hashCode());
    }

    @Test
    public void testEqualsSymmetric() {

        boolean symmetric = issue1.equals(issue2) && issue2.equals(issue1);
        assertTrue(symmetric);
        assertEquals(issue1.hashCode(), issue2.hashCode());
    }

    @Test
    public void testEqualsTransitive() {

        issue.setId(42);
        boolean transitive = issue.equals(issue1) && issue1.equals(issue2);
        assertEquals(transitive, issue.equals(issue2));
    }

    @Test
    public void testEqualsNonNullWithNullGivesFalse() {

        assertFalse(issue1.equals(null));
        assertFalse(issue2.equals(null));
    }

    @Test
    public void testEqualsConsistent() {

        assertTrue(issue1.equals(issue2));
        assertTrue(issue1.equals(issue2));
        assertTrue(issue1.equals(issue2));
        assertTrue(issue1.equals(issue2));
        assertEquals(issue1.hashCode(), issue1.hashCode());
    }

    @Test
    public void testCompareTo() {

        issue.setId(44);
        assertTrue(issue1.compareTo(issue) < 0);
        assertFalse(issue1.compareTo(issue) > 0);
        assertFalse(issue1.compareTo(issue) == 0);
    }

}
