package com.demo.service.user;

import com.demo.entity.User;
import com.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Page<List<User>> findAllByName(String name, Pageable pageable) {
        return userRepo.findAllByName(name, pageable);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
