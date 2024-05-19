package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService{
    private BookingRepository repository;

    @Autowired
    BookingService(BookingRepository repository){
        this.repository = repository;
    }

    @Override
    public Booking save(Booking booking){
        return repository.save(booking);
    }



    @Override
    public Booking read(String bookingId){
        return this.repository.findById(bookingId).orElse(null);
    }

    @Override
    public void delete(String bookingId){repository.deleteById(bookingId);}

    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public Set<Booking> getall(){
        return repository.findAll().stream().collect(Collectors.toSet());

    }

}
