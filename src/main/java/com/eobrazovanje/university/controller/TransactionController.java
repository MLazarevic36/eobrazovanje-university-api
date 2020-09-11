package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Transaction;
import com.eobrazovanje.university.mapper.TransactionMapper;
import com.eobrazovanje.university.mapper.dto.TransactionDTO;
import com.eobrazovanje.university.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionMapper transactionMapper;

    @GetMapping
    public ResponseEntity<Set<TransactionDTO>> getTransactions(Pageable pageable) {
        try {
            Page<Transaction> transactions = transactionService.findAll(pageable);
            return new ResponseEntity<>(transactionMapper.convertToDtos(transactions),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable("id") Long id){
        try {
            Transaction transaction = transactionService.findOne(id);
            return new ResponseEntity<>(transactionMapper.convertToDto(transaction), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.convertToEntity(transactionDTO);
        try {
            transaction = transactionService.save(transaction);
            return new ResponseEntity<>(transactionMapper.convertToDto(transaction), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<TransactionDTO> updateTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.convertToEntity(transactionDTO);
        try {
            transaction.setTransaction_id(transactionDTO.getTransaction_id());
            transaction = transactionService.save(transaction);
            return new ResponseEntity<>(transactionMapper.convertToDto(transaction), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id) {
        try {
            Transaction transaction = transactionService.findOne(id);
            transactionService.delete(transaction);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
