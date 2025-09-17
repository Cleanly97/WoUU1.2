import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Room class.
 */
class RoomTest {

    private Room kitchen;
    private Room hall;

    @BeforeEach
    void setUp() {
        kitchen = new Room("in the kitchen");
        hall = new Room("in the hall");
    }

    @Test
    void constructor_shouldStoreDescription() {
        assertEquals("in the kitchen", kitchen.getShortDescription(),
                "Constructor should set the room description correctly");
    }

    @Test
    void setExit_and_getExit_shouldLinkRooms() {
        kitchen.setExit("north", hall);
        assertSame(hall, kitchen.getExit("north"),
                "getExit should return the room set with setExit");
    }

    @Test
    void getExit_shouldReturnNullForNonExistingDirection() {
        assertNull(kitchen.getExit("west"),
                "If no exit exists for a direction, getExit should return null");
    }

    @Test
    void getLongDescription_shouldIncludeDescriptionAndExits() {
        kitchen.setExit("north", hall);
        String desc = kitchen.getLongDescription();
        assertTrue(desc.contains("in the kitchen"),
                "Long description should contain the room description");
        assertTrue(desc.contains("Exits: north"),
                "Long description should list the exits");
    }

    @Test
    void multipleExits_shouldAllAppearInLongDescription() {
        Room garden = new Room("in the garden");
        kitchen.setExit("north", hall);
        kitchen.setExit("east", garden);

        String desc = kitchen.getLongDescription();
        assertTrue(desc.contains("north"), "Should list 'north' exit");
        assertTrue(desc.contains("east"), "Should list 'east' exit");
    }
}
