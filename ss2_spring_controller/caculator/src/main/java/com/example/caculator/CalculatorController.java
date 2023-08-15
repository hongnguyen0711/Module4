package com.example.caculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping("")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/action")
    public String calculate(@RequestParam(value = "operation") String operation, @RequestParam double operator1, @RequestParam double operator2, RedirectAttributes redirectAttributes) {
        double result = 0;
        switch (operation) {
            case "Addition":
                result = operator1 + operator2;
                break;
            case "Subtraction":
                result = operator1 - operator2;
                break;
            case "Multiplication":
                result = operator1 * operator2;
                break;
            case "Division":
                result = operator1 / operator2;
                break;
        }
        redirectAttributes.addFlashAttribute("result",result);
        return "redirect:/calculator";
    }
}
