package com.example.mycompany.todoapplication.security;

import com.example.mycompany.todoapplication.model.Person;
import com.example.mycompany.todoapplication.model.Role;
import com.example.mycompany.todoapplication.repository.PersonRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UsernamePwdAuthenticationProvider  implements AuthenticationProvider {

    private  final PersonRepository personRepository;

    public UsernamePwdAuthenticationProvider( PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
           String email = authentication.getName();
           String pwd = authentication.getCredentials().toString();
           Person person = personRepository.readByEmail(email);
           if(null != person && person.getPersonId()>0 && pwd.equals(person.getPassword())){
               return new UsernamePasswordAuthenticationToken(person.getName() ,pwd , getGrantedAuthorities(person.getRole()));
        } else{
               throw  new BadCredentialsException("Invalid credentials!");

        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Role role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
