package com.nst.dms.security;

/**
 * Created by nmarkovi on 5/20/18.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
