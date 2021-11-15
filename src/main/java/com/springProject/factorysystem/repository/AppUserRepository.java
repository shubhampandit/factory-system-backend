package com.springProject.factorysystem.repository;

import com.springProject.factorysystem.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    public AppUser findByUsername(String username);
}
