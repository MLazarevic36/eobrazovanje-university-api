package com.eobrazovanje.university.service.interfaces;

import com.eobrazovanje.university.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionInterface {

    Transaction findOne(Long id);
    Page<Transaction> findAll(Pageable pageable);
    Transaction save(Transaction transaction);
    Transaction update(Transaction transaction);
    void delete(Transaction transaction);

}
