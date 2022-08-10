package com.KPI.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KPI.backend.model.Records;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Long> {

}
