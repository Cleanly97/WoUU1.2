import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class that is implemented to test the current exsisting rooms in the games current state
 * The test checks the exits and if the descriptions are correct for each room.
 */
class RoomTest {

    @Test
    void testExits() {
        Room room1 = new Room("in a classroom");
        Room room2 = new Room("in a lab");
        room1.setExit("north", room2);

        assertEquals(room2, room1.getExit("north"));
        assertNull(room1.getExit("south"));
    }

    @Test
    void testLongDescriptionContainsExits() {
        Room room = new Room("outside");
        Room lab = new Room("in a lab");
        room.setExit("east", lab);

        String desc = room.getLongDescription();
        assertTrue(desc.contains("outside"));
        assertTrue(desc.contains("east"));
    }
}
