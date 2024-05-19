package za.ac.cput.factory;

import za.ac.cput.domain.Car;

public class CarFactory {

    public static Car createCar(String carID, String userID, String carInformation, String rate, String availability, String status) {
        return new Car.Builder()
                .setCarID(carID)
                .setUserID(userID)
                .setCarInformation(carInformation)
                .setRate(rate)
                .setAvailability(availability)
                .setStatus(status)
                .build();
    }

    public static Car copyCar(Car car) {
        return new Car.Builder()
                .copy(car)
                .build();
    }
}
