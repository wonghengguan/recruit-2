package com.carrental.backend.services.implementation;

import com.carrental.backend.form.UserForm;
import com.carrental.backend.model.User;
import com.carrental.backend.repository.UserRepository;
import com.carrental.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(UserForm form) {
        User user = userRepository.getUserByID(form.getId());
        if(user!=null) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserByUsernameAndPassword(UserForm form) {
        User user = userRepository.getUserByUsernameAndPassword(form.getUsername(), form.getPassword());
        if(user!=null) {
            return user;
        }
        return null;
    }
}
