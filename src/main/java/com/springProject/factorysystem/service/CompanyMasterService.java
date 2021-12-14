package com.springProject.factorysystem.service;

import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import org.springframework.http.ResponseEntity;

public interface CompanyMasterService {
    public ResponseEntity<Object> getCompanyDetails();
    public CompanyMaster getCompanyById(String id);
    public ResponseEntity<Object> getCompanyDetailByName(String name);
    public ResponseEntity<Object> postCompanyDetail(CompanyMaster companyDeatil);
}
