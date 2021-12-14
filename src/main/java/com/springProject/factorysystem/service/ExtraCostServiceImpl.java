package com.springProject.factorysystem.service;

import com.springProject.factorysystem.entity.referenceEntities.ExtraCostDetails;
import com.springProject.factorysystem.repository.ExtraCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraCostServiceImpl implements ExtraCostService {

    @Autowired
    private ExtraCostRepository extraCostRepository;

    @Override
    public ResponseEntity<Object> getExtraCost() {
        List<ExtraCostDetails> extraCosts = extraCostRepository.findAll();
        ExtraCostDetails extraCost = extraCosts.get(0);
        return ResponseEntity.ok(extraCost);
    }

    @Override
    public ResponseEntity<Object> postExtraCost(ExtraCostDetails extraCost) {
        ExtraCostDetails extraCostDetails = extraCostRepository.save(extraCost);
        return new ResponseEntity<>(extraCostDetails, HttpStatus.CREATED);
    }
}
