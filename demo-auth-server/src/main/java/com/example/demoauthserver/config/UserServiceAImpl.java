package com.example.demoauthserver.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
@Service
class UserServiceAImpl implements UserService {




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        Collection<GrantedAuthority> authorities = new ArrayList<>();

        CustomUserDetails user = new CustomUserDetails(s,  "123456", authorities);

        return user;
    }
}
