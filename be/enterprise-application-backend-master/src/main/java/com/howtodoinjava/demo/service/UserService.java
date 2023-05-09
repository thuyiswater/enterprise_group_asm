package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.UserEntity;
import com.howtodoinjava.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserEntity> getAllUsers(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<UserEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<UserEntity>();
        }
    }

    public UserEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

    public UserEntity createUser(UserEntity entity) throws RecordNotFoundException
    {
        UserEntity createUser = repository.save(entity);
        return createUser;
    }

    public UserEntity updateUser(UserEntity entity) throws RecordNotFoundException {
        Optional<UserEntity> user = repository.findById(entity.getId());
        UserEntity existingUser = user.get();

        existingUser.setId(entity.getId());
        existingUser.setUserName(entity.getUserName());
        existingUser.setUserEmail(entity.getUserEmail());
        existingUser.setUserPassword(entity.getUserPassword());
        existingUser.setUserPhoneNumber(entity.getUserPhoneNumber());

        existingUser = repository.save(existingUser);

        return existingUser;
    }
}
