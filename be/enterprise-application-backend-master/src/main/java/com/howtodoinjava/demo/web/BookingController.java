package com.howtodoinjava.demo.web;

import java.util.List;


import com.howtodoinjava.demo.model.BookingEntity;
import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookings")
public class BookingController
{
    @Autowired
    BookingService service;

    @GetMapping
    public ResponseEntity<List<BookingEntity>> getAllBookings(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<BookingEntity> list = service.getAllBookings(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<BookingEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingEntity> getBookingById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        BookingEntity entity = service.getBookingById(id);

        return new ResponseEntity<BookingEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingEntity> createBooking(@RequestBody BookingEntity booking)
            throws RecordNotFoundException {
        BookingEntity created = service.createBooking(booking);
        return new ResponseEntity<BookingEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingEntity> updateBooking(@RequestBody BookingEntity booking)
            throws RecordNotFoundException {
        BookingEntity updated = service.updateBooking(booking);
        return new ResponseEntity<BookingEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}