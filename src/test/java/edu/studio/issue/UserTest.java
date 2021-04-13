package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() throws Exception {
        user = new User();
        user1 = new User();
        user1.setId(123);
        user2 = new User();
        user2.setId(123);
    }

    @Test
    void testProperties() {

        user.setLogin("utsav");
        assertEquals("utsav", user.getLogin());

        user.setId(12345);
        assertEquals(12345, user.getId());
    }

    @Test
    void testToStringFull() {
        user.setId(12345);
        user.setLogin("Utsav");

        assertEquals("Username: Utsav, Id: 12345", user.toString());
    }

    @Test
    void testToStringEmpty() {

        assertEquals("Username: null, Id: 0", user.toString());
    }

    @Test
    void testToStringPartial() {

        user.setLogin("Utsav");
        assertEquals("Username: Utsav, Id: 0", user.toString());
    }

    @Test
    public void testEqualsReferenceEquality() {

        user1 = user2;
        assertSame(user1, user2); // reference equality ==
    }

    @Test
    public void testEqualsValueEquality() {

        assertEquals(user1, user2); // value equality .equals()

        // equal objects must have equal hash codes
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testEqualsSymmetric() {

        boolean symmetric = user1.equals(user2) && user2.equals(user1);
        assertTrue(symmetric);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testEqualsTransitive() {

        user.setId(123);
        boolean transitive = user.equals(user1) && user1.equals(user2);
        assertEquals(transitive, user.equals(user2));
    }

    @Test
    public void testEqualsNonNullWithNullGivesFalse() {

        assertFalse(user1.equals(null));
        assertFalse(user2.equals(null));
    }

    @Test
    public void testEqualsConsistent() {

        assertTrue(user1.equals(user2));
        assertTrue(user1.equals(user2));
        assertTrue(user1.equals(user2));
        assertTrue(user1.equals(user2));
        assertEquals(user1.hashCode(), user1.hashCode());
    }
    
    @Test
    public void testEqualsTwoDifferentClassObjectsGivesFalse() {

        assertFalse(user.equals(new Issue()));
    }
    
    @Test
    public void testEqualsDifferentIdGivesFalse() {

        user.setId(4);
        assertFalse(user.equals(user1));
    }

    @Test
    public void testCompareToSmallerYieldsTrue() {

        user.setId(444);
        assertTrue(user1.compareTo(user) < 0);
        
    }
    
    @Test
    public void testCompareToGreaterYieldsTrue() {

        user.setId(28);
        assertTrue(user1.compareTo(user) > 0);

    }
    
    @Test
    public void testCompareTo2EqualYieldsTrue() {

        user.setId(123);
        assertTrue(user1.compareTo(user) == 0);

    }

}
