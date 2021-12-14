package com.springProject.factorysystem.service;

import com.springProject.factorysystem.entity.referenceEntities.ExtraCostDetails;
import org.springframework.http.ResponseEntity;

public interface ExtraCostService {
    public ResponseEntity<Object> getExtraCost();

    public ResponseEntity<Object> postExtraCost(ExtraCostDetails extraCost);
}
