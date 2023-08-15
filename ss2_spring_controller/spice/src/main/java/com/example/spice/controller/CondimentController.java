package com.example.spice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/condiment")
public class CondimentController {
    @GetMapping("")
    public String showCondiment() {
        return "list";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "Please choose condiment!", required = false) String[] condiment, Model model) {
        List<String> list = new ArrayList<>();
        if (condiment != null) {
            for (String value : condiment) {
                list.add(value);
            }
            model.addAttribute("list", list);
        } else {
            model.addAttribute("mess", "Please choose condiment!");
        }
        return "list";
    }
}
