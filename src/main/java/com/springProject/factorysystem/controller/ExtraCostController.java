package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.entity.referenceEntities.ExtraCostDetails;
import com.springProject.factorysystem.service.ExtraCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/extra-cost")
public class ExtraCostController {

    @Autowired
    private ExtraCostService extraCostService;

    @GetMapping("/")
    public ResponseEntity<Object> getExtraCost() {
        return extraCostService.getExtraCost();
    }

    @PostMapping("/")
    public ResponseEntity<Object> postExtraCost(@RequestBody ExtraCostDetails extraCostDetails) {
        return extraCostService.postExtraCost(extraCostDetails);
    }
}
