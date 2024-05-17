package za.ac.cput.repository;

import za.ac.cput.domain.CarInformation;
import za.ac.cput.domain.Review;

import java.util.List;

public interface IReviewRepository extends IRepository<Review, String>{
    Review read(String id);

    List<CarInformation> getAll();
}
