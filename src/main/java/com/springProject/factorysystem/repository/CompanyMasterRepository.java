package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, String> {
    public List<CompanyMaster> findByNameContaining(String name);
}
