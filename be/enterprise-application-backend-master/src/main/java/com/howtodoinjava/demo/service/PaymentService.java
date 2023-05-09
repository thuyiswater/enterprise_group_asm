package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.model.PaymentEntity;
import com.howtodoinjava.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;


@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    public List<PaymentEntity> getAllPayments(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<PaymentEntity> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PaymentEntity>();
        }
    }

    public PaymentEntity getPaymentById(Long id) throws RecordNotFoundException
    {
        Optional<PaymentEntity> payment = repository.findById(id);

        if(payment.isPresent()) {
            return payment.get();
        } else {
            throw new RecordNotFoundException("No payment record exist for given id");
        }
    }

    public PaymentEntity createPayment(PaymentEntity entity) throws RecordNotFoundException
    {
        PaymentEntity createPayment = repository.save(entity);
        return createPayment;
    }

    public PaymentEntity updatePayment(PaymentEntity entity) throws RecordNotFoundException {
        Optional<PaymentEntity> payment = repository.findById(entity.getId());
        PaymentEntity existingPayment = payment.get();

        existingPayment.setId(entity.getId());
        existingPayment.setPaymentType(entity.getPaymentType());
        existingPayment.setPaymentAmount(entity.getPaymentAmount());
        existingPayment.setPaymentDate(entity.getPaymentDate());
        existingPayment.setPaymentStatus(entity.getPaymentStatus());

        existingPayment = repository.save(existingPayment);

        return existingPayment;
    }
}