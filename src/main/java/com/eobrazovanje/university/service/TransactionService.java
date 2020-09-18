package com.eobrazovanje.university.service;

import com.eobrazovanje.university.entity.Transaction;
import com.eobrazovanje.university.mapper.TransactionMapper;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TransactionDTO;
import com.eobrazovanje.university.repository.TransactionRepository;
import com.eobrazovanje.university.service.interfaces.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TransactionService implements TransactionInterface {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

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

    public PagedResponse<TransactionDTO> getAllTransactions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "transaction_id");

        Page<Transaction> transactions = transactionRepository.findAllTransactions(pageable);

        if (transactions.getNumberOfElements() == 0) {
            return new PagedResponse<TransactionDTO>(Collections.emptySet(), transactions.getNumber(), transactions.getSize(),
                    transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());
        }

        return new PagedResponse<TransactionDTO>(transactionMapper.convertToDtos(transactions), transactions.getNumber(), transactions.getSize(),
                transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());

    }
}
