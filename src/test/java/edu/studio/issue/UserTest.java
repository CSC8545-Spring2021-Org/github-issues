package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        user = new User();
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

}
