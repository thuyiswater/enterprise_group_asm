package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<EmployeeEntity> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public EmployeeEntity createEmployee(EmployeeEntity entity) throws RecordNotFoundException
    {
        EmployeeEntity createEmployee = repository.save(entity);
        return createEmployee;
    }

    public EmployeeEntity updateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());
        EmployeeEntity existingEmployee= employee.get();

        existingEmployee.setEmail(entity.getEmail());
        existingEmployee.setFirstName(entity.getFirstName());
        existingEmployee.setLastName(entity.getLastName());
        existingEmployee.setPhoneNumber(entity.getPhoneNumber());
        existingEmployee.setPassword(entity.getPassword());
        existingEmployee.setRole(entity.getRole());

        existingEmployee = repository.save(existingEmployee);

        return existingEmployee;
    }
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}