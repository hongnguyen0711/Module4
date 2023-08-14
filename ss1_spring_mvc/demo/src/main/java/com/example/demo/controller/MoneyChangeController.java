package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyChangeController {
    @GetMapping("/change/input")
    public String showInputForm() {
        return "input";
    }

    @PostMapping("/change/input")
    public String change(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = usd * rate;
        model.addAttribute("result", result);
        return "input";
    }
}
