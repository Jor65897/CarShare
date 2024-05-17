package za.ac.cput.factory;

import za.ac.cput.domain.CarInformation;
import za.ac.cput.util.Helper;

public class CarInformationFactory {
    public static CarInformation buildCarInformation(String carId, String make, String model, String year,
                                                     String licensePlate, String description, String features) {
        if (Helper.isNullOrEmpty(carId) || Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(licensePlate)
                || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(features)) {
            return null;
        }

        return new CarInformation.Builder()
                .setCarId(carId)
                .setMake(make)
                .setModel(model)
                .setYear(year)
                .setLicensePlate(licensePlate)
                .setDescription(description)
                .setFeatures(features)
                .build();
    }

    public static CarInformation buildCarInformation(String make, String model, String year,
                                                     String licensePlate, String description, String features) {
        if (Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(licensePlate)
                || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(features)) {
            return null;
        }

        return new CarInformation.Builder()
                .setMake(make)
                .setModel(model)
                .setYear(year)
                .setLicensePlate(licensePlate)
                .setDescription(description)
                .setFeatures(features)
                .build();

    }
}