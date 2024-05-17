package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryTest {

    private AddressRepository repository;
    private Address address1, address2;

    @BeforeEach
    void setUp() {
        repository = AddressRepository.getRepository();
        address1 = new Address.Builder()
                .setAddressId("A123")
                .setUserId("U456")
                .setStreetNumber(123)
                .setStreetName("Main Street")
                .setSuburb("Downtown")
                .setPostalCode(12345)
                .build();

        address2 = new Address.Builder()
                .setAddressId("A124")
                .setUserId("U457")
                .setStreetNumber(124)
                .setStreetName("Second Street")
                .setSuburb("Uptown")
                .setPostalCode(54321)
                .build();
    }

    @Test
    void getRepository() {
        AddressRepository repo1 = AddressRepository.getRepository();
        AddressRepository repo2 = AddressRepository.getRepository();
        assertSame(repo1, repo2, "Repository instances are not the same");
    }

    @Test
    void create() {
        Address created = repository.create(address1);
        assertNotNull(created);
        assertEquals(address1, created);

        Address duplicate = repository.create(address1);
        assertNull(duplicate, "Duplicate address creation should return null");
    }

    @Test
    void read() {
        repository.create(address1);
        Address read = repository.read(address1.getAddressId());
        assertNotNull(read);
        assertEquals(address1, read);

        Address nonExistent = repository.read("NonExistentId");
        assertNull(nonExistent, "Reading a non-existent address should return null");
    }

    @Test
    void update() {
        repository.create(address1);

        Address updatedAddress = new Address.Builder()
                .copy(address1)
                .setStreetName("Updated Main Street")
                .build();

        Address updated = repository.update(updatedAddress);
        assertNotNull(updated);
        assertEquals("Updated Main Street", updated.getStreetName());
    }

    @Test
    void delete() {
        repository.create(address1);
        boolean deleted = repository.delete(address1.getAddressId());
        assertTrue(deleted);

        boolean notDeleted = repository.delete("NonExistentId");
        assertFalse(notDeleted, "Deleting a non-existent address should return false");
    }
}
