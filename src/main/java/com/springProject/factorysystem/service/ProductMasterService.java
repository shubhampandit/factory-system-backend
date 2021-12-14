package com.springProject.factorysystem.service;

import com.springProject.factorysystem.entity.referenceEntities.master.ProductMaster;
import org.springframework.http.ResponseEntity;

public interface ProductMasterService {
    public ResponseEntity<Object> searchProduct(String searchTerm);
    public ResponseEntity<Object> postProduct(ProductMaster product);
}
