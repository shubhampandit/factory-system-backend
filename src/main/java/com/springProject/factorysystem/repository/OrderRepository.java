package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    public Orders findByOrderId(String orderId);
}
