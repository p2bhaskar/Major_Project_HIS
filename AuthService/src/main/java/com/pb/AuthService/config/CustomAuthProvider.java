package com.pb.AuthService.config;


import com.pb.AuthService.clients.LoginResponseFeignClient;
import com.pb.AuthService.login_model.Login_Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginResponseFeignClient loginResponseFeignClient;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username = authentication.getName();
       String pwd = authentication.getCredentials().toString();

       Login_Credentials credentials = loginResponseFeignClient.getLoginResponse(username);

           if(passwordEncoder.matches(pwd,credentials.getPassword())){
               return new UsernamePasswordAuthenticationToken(username,pwd,new ArrayList<SimpleGrantedAuthority>());
           }else{
               throw new BadCredentialsException("Invalid Password ..");
           }
       }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}

/*  private List<GrantedAuthority> getGrantedAuthorities(Set<Authorities> authorities) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authorities authority : authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }*/




