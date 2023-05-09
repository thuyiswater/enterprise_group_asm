package com.howtodoinjava.demo.web;

import java.util.List;

import com.howtodoinjava.demo.model.DriverEntity;
import com.howtodoinjava.demo.model.PaymentEntity;
import com.howtodoinjava.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.demo.exception.RecordNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payments")
public class PaymentController
{
    @Autowired
    PaymentService service;

    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAllPayments(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<PaymentEntity> list = service.getAllPayments(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<PaymentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        PaymentEntity entity = service.getPaymentById(id);

        return new ResponseEntity<PaymentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentEntity> createPayment(@RequestBody PaymentEntity payment)
            throws RecordNotFoundException {
        PaymentEntity created = service.createPayment(payment);
        return new ResponseEntity<PaymentEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentEntity> updatePayment(@RequestBody PaymentEntity payment)
            throws RecordNotFoundException {
        PaymentEntity updated = service.updatePayment(payment);
        return new ResponseEntity<PaymentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}