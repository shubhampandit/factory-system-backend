package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import com.springProject.factorysystem.service.CompanyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyMasterController {

    @Autowired
    private CompanyMasterService companyMasterService;

    @GetMapping("/search/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> searchCompany(@PathVariable String name){
        return companyMasterService.getCompanyDetailByName(name);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> postCompanyDetail(@RequestBody CompanyMaster companyMaster){
        return companyMasterService.postCompanyDetail(companyMaster);
    }
}
