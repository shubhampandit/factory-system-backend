package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.referenceEntities.ExtraCostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraCostRepository extends JpaRepository<ExtraCostDetails, String> {
}
