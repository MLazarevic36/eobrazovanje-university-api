package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction getByStudent(Long student_id);
}
