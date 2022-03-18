package com.example.companyemployeespring1.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    public CurrentUser(String username, String password) {
        super(username, password, authorities);
    }
}
