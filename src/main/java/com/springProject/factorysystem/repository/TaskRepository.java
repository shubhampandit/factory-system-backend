package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, String> {
    public List<Tasks> findByAssignedTo(String assignedTo);
}
