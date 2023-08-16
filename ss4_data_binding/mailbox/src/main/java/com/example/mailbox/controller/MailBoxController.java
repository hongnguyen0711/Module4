package com.example.mailbox.controller;

import com.example.mailbox.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailBoxController {
    @GetMapping("")
    public String showMailBox(Model model) {
        model.addAttribute("mailBox", new MailBox());
        return "box";
    }

    @PostMapping("")
    public String update(@ModelAttribute MailBox mailBox, Model model) {
        model.addAttribute("mailBox",mailBox);
        return "box";
    }
}
