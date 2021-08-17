/*package com.andrei.myapp.security;

import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Couldn't find user");
        }
        return new MyUserDetails(user);
    }
}*/
