package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CarInformation;
import za.ac.cput.factory.CarInformationFactory;

import static org.junit.jupiter.api.Assertions.*;

class CarInformationRepositoryTest {

    private static CarInformationRepository repository = CarInformationRepository.getRepository();

    private CarInformation carInformation = CarInformationFactory.buildCarInformation("123", "BMW", "M4", "2021",
            "CA 122-111", "M performance", "800hps");

    @Test
    void create() {
        CarInformation created = repository.create(carInformation);
        assertNotNull(created);
        assertEquals(carInformation.getCarInformationId(), created.getCarInformationId());
        System.out.println(created);
    }

    @Test
    void read() {
        repository.create(carInformation); // Ensure the object is created before reading
        CarInformation read = repository.read(carInformation.getCarInformationId());
        assertNotNull(read);
        assertEquals(carInformation.getCarInformationId(), read.getCarInformationId());
        System.out.println(read);
    }

    @Test
    void update() {
        repository.create(carInformation); // Ensure the object is created before updating
        CarInformation updatedCarInformation = new CarInformation.Builder()
                .copy(carInformation)
                .setMake("Volvo")
                .build();
        CarInformation updated = repository.update(updatedCarInformation);
        assertNotNull(updated);
        assertEquals("Volvo", updated.getMake());
        System.out.println(updated);
    }

    @Test
    void delete() {
        repository.create(carInformation); // Ensure the object is created before deleting
        boolean success = repository.delete(carInformation.getCarInformationId());
        assertTrue(success);
        CarInformation deletedCarInformation = repository.read(carInformation.getCarInformationId());
        assertNull(deletedCarInformation);
        System.out.println("Success: BMW deleted");
    }

    @Test
    void getAll() {
        repository.create(carInformation); // Ensure at least one object is created
        assertNotNull(repository.getAll());
        assertTrue(repository.getAll().size() > 0);
        System.out.println(repository.getAll());
    }
}

