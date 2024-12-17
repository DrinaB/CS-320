/*
 Drina Baptiste
 CS 320
 11/14/24
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "Drina", "Baptiste", "5701234567", "Patrick SFB, FL");
        assertTrue(contactService.addContact(contact));
        assertNotNull(contactService.getContact("12345"));
    }

    @Test
    public void testAddContactDuplicateId() {
        Contact contact1 = new Contact("12345", "Drina", "Baptiste", "5701234567", "Patrick SFB, FL");
        Contact contact2 = new Contact("12345", "Stephen", "Curry", "0987654321", "Chase Stadium");
        contactService.addContact(contact1);
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "Drina", "Baptiste", "5701234567", "Patrick SFB, FL");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("12345"));
        assertNull(contactService.getContact("12345"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertFalse(contactService.deleteContact("99999"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("12345", "Drina", "Baptiste", "5701234567", "Patrick SFB, FL");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("12345", "Stephen", "Curry", "0987654321", "Chase Center"));
        Contact updatedContact = contactService.getContact("12345");
        assertEquals("Stephen", updatedContact.getFirstName());
        assertEquals("Curry", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("Chase Stadium", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactNotFound() {
        assertFalse(contactService.updateContact("99999", "Stephen", "Curry", "0987654321", "Chase Stadium"));
    }
}
