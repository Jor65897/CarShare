package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class CarInformation {
    @Id
    private String CarInformationId;
    private String carId;
    private String Make;
    private String model;
    private String year;
    private String licensePlate;
    private String description;
    private String features;

    protected CarInformation(){}

    private CarInformation(Builder builder){
        this.CarInformationId = builder.CarInformationId;
        this.carId = builder.carId;
        this.Make = builder.Make;
        this.model = builder.model;
        this.year = builder.year;
        this.licensePlate = builder.licensePlate;
        this.description = builder.description;
        this.features = builder.features;
    }

    public String getCarInformationId() {
        return CarInformationId;
    }

    public String getCarId() {
        return carId;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getDescription() {
        return description;
    }

    public String getFeatures() {
        return features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarInformation that = (CarInformation) o;
        return Objects.equals(CarInformationId, that.CarInformationId) && Objects.equals(carId, that.carId) && Objects.equals(Make, that.Make) && Objects.equals(model, that.model) && Objects.equals(year, that.year) && Objects.equals(licensePlate, that.licensePlate) && Objects.equals(description, that.description) && Objects.equals(features, that.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CarInformationId, carId, Make, model, year, licensePlate, description, features);
    }

    @Override
    public String toString() {
        return "CarInformation{" +
                "CarInformationId='" + CarInformationId + '\'' +
                ", carId='" + carId + '\'' +
                ", Make='" + Make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", description='" + description + '\'' +
                ", features='" + features + '\'' +
                '}';
    }

    public static class Builder{
        private String CarInformationId;
        private String carId;
        private String Make;
        private String model;
        private String year;
        private String licensePlate;
        private String description;
        private String features;

        public Builder setCarInformationId(String carInformationId) {
            CarInformationId = carInformationId;
            return this;
        }

        public Builder setCarId(String carId) {
            this.carId = carId;
            return this;
        }

        public Builder setMake(String make) {
            Make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setFeatures(String features) {
            this.features = features;
            return this;
        }

        public Builder copy(CarInformation carInformation){
            this.CarInformationId = carInformation.CarInformationId;
            this.carId = carInformation.carId;
            this.Make = carInformation.Make;
            this.model = carInformation.model;
            this.year = carInformation.year;
            this.licensePlate = carInformation.licensePlate;
            this.description = carInformation.description;
            this.features = carInformation.features;
            return this;
        }

        public CarInformation build(){return new CarInformation(this);}
    }
}
