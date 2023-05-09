package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.BookingEntity;
import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public List<BookingEntity> getAllBookings(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<BookingEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<BookingEntity>();
        }
    }

    public BookingEntity getBookingById(Long id) throws RecordNotFoundException
    {
        Optional<BookingEntity> booking = repository.findById(id);

        if(booking.isPresent()) {
            return booking.get();
        } else {
            throw new RecordNotFoundException("No booking record exist for given id");
        }
    }

    public BookingEntity createBooking(BookingEntity entity) throws RecordNotFoundException
    {
        BookingEntity createdBooking = repository.save(entity);
        return createdBooking;
    }

    public BookingEntity updateBooking(BookingEntity entity) throws RecordNotFoundException {
        Optional<BookingEntity> booking = repository.findById(entity.getId());
        BookingEntity existingBooking = booking.get();

        existingBooking.setId(entity.getId());
        existingBooking.setBookingDate(entity.getBookingDate());
        existingBooking.setUser(entity.getUser());
        existingBooking.setBookingPickUpLocation(entity.getBookingPickUpLocation());
        existingBooking.setBookingDropOffLocation(entity.getBookingDropOffLocation());
        existingBooking.setBookingPickUpTime(entity.getBookingPickUpTime());
        existingBooking.setBookingDropOffTime(entity.getBookingDropOffTime());
        existingBooking.setBookingNumberOfPassengers(entity.getBookingNumberOfPassengers());
        existingBooking.setVehicle(entity.getVehicle());
        existingBooking.setDriver(entity.getDriver());
        existingBooking.setPayment(entity.getPayment());
        existingBooking.setBookingStatus(entity.getBookingStatus());

        existingBooking = repository.save(existingBooking);

        return existingBooking;
    }
}
