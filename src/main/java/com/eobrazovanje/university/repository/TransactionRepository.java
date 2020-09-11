package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction getByStudent(Long student_id);

    @Query(value = "SELECT * FROM transactions WHERE student_id = :id", nativeQuery = true)
    Page<Transaction> findTransactionsByStudent(@Param("id") Long id, Pageable pageable);
}
