package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.entity.referenceEntities.master.ProductMaster;
import com.springProject.factorysystem.service.ProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductMasterController {

    @Autowired
    private ProductMasterService productMasterService;

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<Object> searchProduct(@PathVariable String searchTerm){
        return productMasterService.searchProduct(searchTerm);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> postProduct(@RequestBody ProductMaster product){
        return productMasterService.postProduct(product);
    }
}
