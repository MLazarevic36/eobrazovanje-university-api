package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {

    @Query(value = "SELECT * FROM terms WHERE deleted = 0 ORDER BY term_id", nativeQuery = true)
    Page<Term> findAllByDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM terms WHERE deleted = 0 ORDER BY term_id", nativeQuery = true)
    List<Term> findAllByDeletedOrdered();

}
