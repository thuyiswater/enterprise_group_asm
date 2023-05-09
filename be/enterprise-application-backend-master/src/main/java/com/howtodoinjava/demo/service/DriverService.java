package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class DriverService {

    @Autowired
    DriverRepository repository;

    public List<DriverEntity> getAllDrivers(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<DriverEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DriverEntity>();
        }
    }

    public DriverEntity getDriverById(Long id) throws RecordNotFoundException
    {
        Optional<DriverEntity> driver = repository.findById(id);

        if(driver.isPresent()) {
            return driver.get();
        } else {
            throw new RecordNotFoundException("No driver record exist for given id");
        }
    }

    public DriverEntity createDriver(DriverEntity entity) throws RecordNotFoundException
    {
        DriverEntity createdDriver = repository.save(entity);
        return createdDriver;
    }

    public DriverEntity updateDriver(DriverEntity entity) throws RecordNotFoundException {
        Optional<DriverEntity> driver = repository.findById(entity.getId());
        DriverEntity existingDriver = driver.get();

        existingDriver.setId(entity.getId());
        existingDriver.setDriverName(entity.getDriverName());
        existingDriver.setDriverPhoneNumber(entity.getDriverPhoneNumber());
        existingDriver.setDriverLicenseNumber(entity.getDriverLicenseNumber());
        existingDriver.setDriverYearOfExperience(entity.getDriverYearOfExperience());
        existingDriver.setDriverAvatar(entity.getDriverAvatar());
        existingDriver.setDriverPassword(entity.getDriverPassword());

        existingDriver = repository.save(existingDriver);

        return existingDriver;
    }


    public void deleteDriverById(Long id) throws RecordNotFoundException
    {
        Optional<DriverEntity> driver = repository.findById(id);

        if(driver.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No driver record exist for given id");
        }
    }
}
