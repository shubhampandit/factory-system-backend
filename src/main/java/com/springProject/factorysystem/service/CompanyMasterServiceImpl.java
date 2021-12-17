package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetCompanySearchDTO;
import com.springProject.factorysystem.dto.PostCompanyResponse;
import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import com.springProject.factorysystem.repository.CompanyMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyMasterServiceImpl implements CompanyMasterService {

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    @Override
    @Transactional
    public ResponseEntity<Object> getCompanyDetails() {
        return null;
    }

    @Override
    public CompanyMaster getCompanyById(String id) {
        return companyMasterRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> getCompanyDetailByName(String name) {
        List<CompanyMaster> companies = companyMasterRepository.findByNameContaining(name);
        List<GetCompanySearchDTO> searchResults = companies.stream().map(company -> {
            return new GetCompanySearchDTO(company.getName(), company.getId());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(searchResults);
    }

    @Override
    public ResponseEntity<Object> postCompanyDetail(CompanyMaster companyDeatil) {
        CompanyMaster companyMaster = companyMasterRepository.save(companyDeatil);

        PostCompanyResponse postCompanyResponse = new PostCompanyResponse();
        postCompanyResponse.setCompanyId(companyMaster.getId());

        return new ResponseEntity<>(postCompanyResponse, HttpStatus.CREATED);
    }

}
