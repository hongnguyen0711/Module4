package com.example.form_dang_ki.controller;

import com.example.form_dang_ki.model.User;
import com.example.form_dang_ki.dto.UserDto;
import com.example.form_dang_ki.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService service;
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "form";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        service.addUser(user);
        model.addAttribute("success", "Sign Up Success");
        return "success";
    }
}
