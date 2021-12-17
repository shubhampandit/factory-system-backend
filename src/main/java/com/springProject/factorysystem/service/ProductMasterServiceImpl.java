package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.PostProductResponse;
import com.springProject.factorysystem.dto.GetProductSearchDTO;
import com.springProject.factorysystem.entity.referenceEntities.master.ProductMaster;
import com.springProject.factorysystem.repository.ProductMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMasterServiceImpl implements ProductMasterService {

    @Autowired
    private ProductMasterRepository productMasterRepository;

    @Override
    public ResponseEntity<Object> searchProduct(String searchTerm) {
        List<ProductMaster> products = productMasterRepository.findByNameContaining(searchTerm);
        List<GetProductSearchDTO> response = products.stream().map(product -> {
            return new GetProductSearchDTO(
                    product.getId(),
                    product.getName(),
                    product.getBasicRate(),
                    product.getGuessingDiff()
            );
        }).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Object> postProduct(ProductMaster product) {
        ProductMaster postedProduct = productMasterRepository.save(product);
        PostProductResponse response = new PostProductResponse();
        response.setProductId(postedProduct.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
