package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String showDictionary() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String search(@RequestParam String anh, Model model) {
        Map<String, String> map = new TreeMap<>();
        map.put("flexible", "linh hoạt");
        map.put("flex", "uốn cong");
        map.put("flow", "chảy");
        if (map.get(anh) == null) {
            model.addAttribute("error", "Không tìm thấy!");
        } else {
            model.addAttribute("message", map.get(anh));
        }
        return "dictionary";
    }

}
