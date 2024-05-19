package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Car;
import za.ac.cput.factory.CarFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarServiceTest {

    @Autowired
    private CarService carService;

    private static Name name;
    private static Contact contact;
    private static Address address;

    private static Car car = CarFactory.createCar("123", "456", "Toyota Corolla", "150", "Available", "New");

    @Test
    @Order(1)
    void testCreate() {
        Car createdCar = carService.create(car);
        assertNotNull(createdCar);
        System.out.println("Created Car: " + createdCar);
    }

    @Test
    @Order(2)
    void testRead() {
        Car readCar = carService.read(car.getCarID());
        assertNotNull(readCar);
        System.out.println("Read Car: " + readCar);
    }

    @Test
    @Order(3)
    void testUpdate() {
        Car newCar = new Car.Builder()
                .copyCar(car)
                .setCarID("789")
                .buildCar();
        Car updatedCar = carService.update(newCar);
        assertNotNull(updatedCar);
        System.out.println("Updated Car: " + updatedCar);
    }

    @Test
    @Order(4)
    void testDelete() {
        carService.delete(car.getCarID());
        System.out.println("Car deleted successfully");
    }
}
