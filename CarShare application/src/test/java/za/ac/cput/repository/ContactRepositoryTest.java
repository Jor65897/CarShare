package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {

    private ContactRepository repository;
    private Contact contact1, contact2;

    @BeforeEach
    void setUp() {
        repository = ContactRepository.getRepository();
        contact1 = new Contact.Builder()
                .setContactId("C789")
                .setEmail("example@example.com")
                .setMobileNo(1234567890)
                .build();

        contact2 = new Contact.Builder()
                .setContactId("C790")
                .setEmail("sample@sample.com")
                .setMobileNo(987650)
                .build();
    }

    @Test
    void getRepository() {
        ContactRepository repo1 = ContactRepository.getRepository();
        ContactRepository repo2 = ContactRepository.getRepository();
        assertSame(repo1, repo2, "Repository instances are not the same");
    }

    @Test
    void create() {
        Contact created = repository.create(contact1);
        assertNotNull(created);
        assertEquals(contact1, created);

        Contact duplicate = repository.create(contact1);
        assertNull(duplicate, "Duplicate contact creation should return null");
    }

    @Test
    void read() {
        repository.create(contact1);
        Contact read = repository.read(contact1.getContactId());
        assertNotNull(read);
        assertEquals(contact1, read);

        Contact nonExistent = repository.read("NonExistentId");
        assertNull(nonExistent, "Reading a non-existent contact should return null");
    }

    @Test
    void update() {
        repository.create(contact1);

        Contact updatedContact = new Contact.Builder()
                .copy(contact1)
                .setEmail("updated@example.com")
                .build();

        Contact updated = repository.update(updatedContact);
        assertNotNull(updated);
        assertEquals("updated@example.com", updated.getEmail());
    }

    @Test
    void delete() {
        repository.create(contact1);
        boolean deleted = repository.delete(contact1.getContactId());
        assertTrue(deleted);

        boolean notDeleted = repository.delete("NonExistentId");
        assertFalse(notDeleted, "Deleting a non-existent contact should return false");
    }
}
