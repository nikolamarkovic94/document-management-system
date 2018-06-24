package com.nst.dms.service.impl;

import com.nst.dms.domain.User;
import com.nst.dms.repository.UserRepository;
import com.nst.dms.repository.UserRoleRepository;
import com.nst.dms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

/**
 * Created by nmarkovi on 5/21/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRoles(new HashSet<>(userRoleRepository.findAll()));
        user = userRepository.save(user);

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
