package com.carrental.backend.services;

import com.carrental.backend.form.UserForm;
import com.carrental.backend.model.User;

public interface UserService {
    User getUser(UserForm form);
}
