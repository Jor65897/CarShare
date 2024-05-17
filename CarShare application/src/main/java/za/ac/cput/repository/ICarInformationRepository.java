package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.CarInformation;

import java.util.List;

public interface ICarInformationRepository  extends IRepository<CarInformation, String> {

    CarInformation read(String id);

    List<CarInformation> getAll();
}
