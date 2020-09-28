package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT * FROM documents WHERE deleted = 0 AND student_id = :id", nativeQuery = true)
    Page<Document> findDocumentsByStudent(@Param("id") Long id, Pageable pageable);

}
