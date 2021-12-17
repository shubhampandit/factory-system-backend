package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.PostLoginRequest;
import com.springProject.factorysystem.dto.PostLoginResponse;
import com.springProject.factorysystem.dto.PostSignupRequest;
import com.springProject.factorysystem.entity.AppRole;
import com.springProject.factorysystem.entity.AppUser;
import com.springProject.factorysystem.security.auth.ApplicationUserService;
import com.springProject.factorysystem.security.jwt.JwtUtil;
import com.springProject.factorysystem.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Object> getUser(@RequestBody PostLoginRequest postLoginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            postLoginRequest.getUsername(),
                            postLoginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username and Password", e);
        }

        final UserDetails userDetails = applicationUserService.loadUserByUsername(postLoginRequest.getUsername());
        final String jwtToken = jwtUtil.generateToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new PostLoginResponse(userDetails.getUsername(), roles.get(0), jwtToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> saveUser(@RequestBody PostSignupRequest postSignupRequest) {
        List<AppRole> roles = postSignupRequest.getRoles().stream()
                .map(AppRole::new)
                .collect(Collectors.toList());

        AppUser newUser = new AppUser(postSignupRequest.getUsername(), postSignupRequest.getPassword(), roles);
        appUserService.saveUser(newUser);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
