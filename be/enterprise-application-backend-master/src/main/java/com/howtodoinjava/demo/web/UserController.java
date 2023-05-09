package com.howtodoinjava.demo.web;

import java.util.List;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.model.UserEntity;
import com.howtodoinjava.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<UserEntity> list = service.getAllUsers(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        UserEntity entity = service.getUserById(id);

        return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(UserEntity user)
            throws RecordNotFoundException {
        UserEntity created = service.createUser(user);
        return new ResponseEntity<UserEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user)
            throws RecordNotFoundException {
        UserEntity updated = service.updateUser(user);
        return new ResponseEntity<UserEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

}