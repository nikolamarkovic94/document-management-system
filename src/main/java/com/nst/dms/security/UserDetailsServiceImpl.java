package com.nst.dms.security;

import com.nst.dms.domain.User;
import com.nst.dms.domain.UserRole;
import com.nst.dms.repository.UserRepository;
import com.nst.dms.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by nmarkovi on 4/22/18.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + "does not exist");
        } else {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (UserRole userRole : user.getUserRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
        }
    }
}
