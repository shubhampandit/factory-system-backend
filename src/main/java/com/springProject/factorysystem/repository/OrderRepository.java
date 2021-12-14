package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    public Orders findByOrderId(String orderId);

    public List<Orders> findByAssignedTo(String assignedTo);
}
