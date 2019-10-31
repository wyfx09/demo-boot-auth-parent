package com.example.demoauthserver.config;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by admin on 2018/8/13.
 */
public class CustomUserDetails extends org.springframework.security.core.userdetails.User implements Serializable {


    public CustomUserDetails(String userId, String pwd, Collection<? extends GrantedAuthority> authorities) {
        super(userId, pwd, true, true, true, true, authorities);

    }


}
