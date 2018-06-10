package com.nst.dms.repository;

import com.nst.dms.domain.User;
import com.nst.dms.domain.UserRole;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by nmarkovi on 4/22/18.
 */
public interface UserRoleRepository extends Repository<UserRole, Long> {

    List<UserRole> findByUser(User user);

    List<UserRole> findAll();
}
