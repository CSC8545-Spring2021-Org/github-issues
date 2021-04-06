package edu.studio.issue;

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

}
