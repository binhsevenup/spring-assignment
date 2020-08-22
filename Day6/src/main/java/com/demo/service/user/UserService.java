package com.demo.service.user;

import com.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<List<User>> findAllByName(String name, Pageable pageable);
    User saveUser(User user);
}
