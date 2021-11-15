package com.springProject.factorysystem.security.auth;

import com.springProject.factorysystem.entity.AppUser;
import com.springProject.factorysystem.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(s);

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = appUser.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new ApplicationUser(appUser.getUsername(),
                appUser.getPassword(),
                simpleGrantedAuthorities,
                true,
                true,
                true,
                true);
    }
}
