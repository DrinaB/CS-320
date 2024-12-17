/*
 Drina Baptiste
 CS 320
 11/14/24
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "Drina", "Baptiste", "5701234567", "Patrick SFB, FL");
        assertEquals("12345", contact.getContactId());
        assertEquals("Drina", contact.getFirstName());
        assertEquals("Baptiste", contact.getLastName());
        assertEquals("5701234567", contact.getPhone());
        assertEquals("Patrick SFB, FL", contact.getAddress());
    }

    @Test
    public void testContactInvalidFields() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Drina", "Baptiste", "5701234567", "Patrick SFB, FL"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Baptiste", "5701234567", "Patrick SFB, FL"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Drina", null, "5701234567", "Patrick SFB, FL"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Drina", "Baptiste", "57012345", "Patrick SFB, FL"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Drina", "Baptiste", "5701234567", null));
    }
}
