package com.example.form_dang_ki.service;

import com.example.form_dang_ki.model.User;
import com.example.form_dang_ki.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;

    @Override
    public void addUser(User user) {
        repository.saveUser(user.getFirstName(), user.getLastName(), user.getAge(),user.getPhoneNumber(), user.getEmail());
    }
}
