package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.referenceEntities.master.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, String> {
    public List<ProductMaster> findByNameContaining(String searchTerm);
}
