package za.ac.cput.repository;

import za.ac.cput.domain.CarInformation;
import java.util.ArrayList;
import java.util.List;

public class CarInformationRepository implements ICarInformationRepository {

    private static CarInformationRepository repository = null;
    private List<CarInformation> carInformationList;

    private CarInformationRepository() {
        carInformationList = new ArrayList<>();
    }

    public static CarInformationRepository getRepository() {
        if (repository == null) {
            repository = new CarInformationRepository();
        }
        return repository;
    }

    @Override
    public CarInformation create(CarInformation carInformation) {
        boolean success = carInformationList.add(carInformation);
        if (success) {
            return carInformation;
        }
        return null;
    }

    @Override
    public CarInformation read(CarInformation carInformation) {
        return null;
    }

    @Override
    public CarInformation read(String id) {
        for (CarInformation carInformation : carInformationList) {
            if (carInformation.getCarInformationId().equals(id)) {
                return carInformation;
            }
        }
        return null;
    }

    @Override
    public CarInformation update(CarInformation carInformation) {
        CarInformation oldCarInformation = read(carInformation.getCarInformationId());
        if (oldCarInformation != null) {
            carInformationList.remove(oldCarInformation);
            carInformationList.add(carInformation);
            return carInformation;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        CarInformation carInformationToDelete = read(id);
        if (carInformationToDelete != null) {
            carInformationList.remove(carInformationToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<CarInformation> getallstuff() {
        return null;
    }

    @Override
    public List<CarInformation> getAll() {
        return new ArrayList<>(carInformationList);
    }
}


