package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CarInformation;

import static org.junit.jupiter.api.Assertions.*;

class CarInformationFactoryTest {

    @Test
    void buildCarInformation() {
        CarInformation carInformation = CarInformationFactory.buildCarInformation("011", "BMW", "M4", "2017", "CA 123-456", "It is an M-performance", "800hps, twin turbo Injector");
        assertNotNull(carInformation);
        System.out.println(carInformation);
    }

    @Test
    void testBuildCarInformationWithFail() {
        CarInformation carInformation = CarInformationFactory.buildCarInformation("BMW", "M4", "2017", "CA 123-456", "", "", "800hps, twin turbo Injector");
        assertNotNull(carInformation);
        System.out.println(carInformation);
    }
}