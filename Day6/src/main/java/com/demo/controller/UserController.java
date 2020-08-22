package com.demo.controller;

import com.demo.entity.User;
import com.demo.repository.UserRepo;
import com.demo.service.user.UserService;
import lombok.var;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;

    @GetMapping({"/home"})
    public String home(Model model) {
        model.addAttribute("name", "T1808A");
        return "home";
    }

    @GetMapping("/add-user")
    public String openAddProduct(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/addUser";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "user/listUser";
    }

    @GetMapping({"/users", "/"})
    public String getAllUser(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "user/listUser";
    }

    @DeleteMapping({"/users/{id}"})
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/edit-user/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "user/updateUser";
    }

    @PostMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "user/updateUser";
        }

        userRepo.save(user);
        model.addAttribute("users", userRepo.findAll());
        return "user/listUser";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepo.delete(user);
        model.addAttribute("users", userRepo.findAll());
        return "user/listUser";
    }
}
