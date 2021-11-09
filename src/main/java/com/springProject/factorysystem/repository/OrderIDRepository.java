package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderIDRepository extends JpaRepository<OrderId, String> {
}
