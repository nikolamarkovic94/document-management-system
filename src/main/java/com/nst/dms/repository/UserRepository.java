package com.nst.dms.repository;

import com.nst.dms.domain.User;
import com.nst.dms.domain.UserRole;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by nmarkovi on 4/22/18.
 */
public interface UserRepository extends Repository<User, Long> {

    User findByUserName(String username);

    User save(User user);
}
