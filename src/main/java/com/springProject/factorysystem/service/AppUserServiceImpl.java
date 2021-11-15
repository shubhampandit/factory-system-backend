package com.springProject.factorysystem.service;

import com.springProject.factorysystem.entity.AppUser;
import com.springProject.factorysystem.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
        AppUser newUser = new AppUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
        newUser.setRoles(user.getRoles());

        return appUserRepository.save(newUser);
    }
}
