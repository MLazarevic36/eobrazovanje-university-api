package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Transaction;
import com.eobrazovanje.university.repository.TransactionRepository;
import com.eobrazovanje.university.service.interfaces.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements TransactionInterface {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction findOne(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transaction.setDeleted(true);
        transactionRepository.save(transaction);
    }
}
