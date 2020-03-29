package model;

import org.junit.jupiter.api.Test;
import util.PlayListHelper;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUser() {
        User normalUser = new User("User1", 1, true);
        User proUser = new User("User1", 2, false);
        assertEquals(100, PlayListHelper.getMaxTrackCount(proUser));
        assertEquals(200, PlayListHelper.getMaxTrackCount(normalUser));
    }

}