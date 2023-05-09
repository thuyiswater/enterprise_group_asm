package com.howtodoinjava.demo.web;

import java.net.URI;
import java.util.List;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/drivers")
public class DriverController
{
    @Autowired
    DriverService service;

    @GetMapping
    public ResponseEntity<List<DriverEntity>> getAllDrivers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<DriverEntity> list = service.getAllDrivers(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<DriverEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getDriverById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        DriverEntity entity = service.getDriverById(id);

        return new ResponseEntity<DriverEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<DriverEntity> createDriver(@RequestBody DriverEntity driver)
            throws RecordNotFoundException {
        DriverEntity created = service.createDriver(driver);
        return new ResponseEntity<DriverEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverEntity> updateDriver(@RequestBody DriverEntity driver)
            throws RecordNotFoundException {
        DriverEntity updated = service.updateDriver(driver);
        return new ResponseEntity<DriverEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDriverById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteDriverById(id);
        return HttpStatus.OK;
    }

}