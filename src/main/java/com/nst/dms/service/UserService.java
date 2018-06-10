package com.nst.dms.service;

import com.nst.dms.domain.User;
import com.nst.dms.service.base.BaseService;

/**
 * Created by nmarkovi on 5/21/18.
 */
public interface UserService extends BaseService<User> {

    User findByUsername(String username);
}
