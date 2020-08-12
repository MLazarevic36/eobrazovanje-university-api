package com.eobrazovanje.university.repository;

import com.eobrazovanje.university.entity.Colloquium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColloquiumRepository extends JpaRepository<Colloquium, Long> {
}
