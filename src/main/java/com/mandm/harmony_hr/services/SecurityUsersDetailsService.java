package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.entities.Users;
import com.mandm.harmony_hr.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUsersDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public SecurityUsersDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users returned_user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(returned_user.getUsername())
                .password(returned_user.getPassword())
                .roles(returned_user.getAccessRights().name())
                .build();
    }
}
