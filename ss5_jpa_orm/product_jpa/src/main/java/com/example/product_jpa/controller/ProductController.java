package com.example.product_jpa.controller;

import com.example.product_jpa.model.Product;
import com.example.product_jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("products", list);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirect){
        productService.addProduct(product);
        redirect.addFlashAttribute("success", "save successfully!");
        return "redirect:/product/list";
    }
    @GetMapping("/{id}/view")
    public String detail(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model ){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirect){
        productService.update(product);
        redirect.addFlashAttribute("message", "Update successful!");
        return "redirect:/product/list";
    }
    @PostMapping("/search")
    public String searchProduct(@RequestParam String keyword, Model model){
        List<Product> products = productService.search(keyword);
        model.addAttribute("products", products);
        return "list";
    }
}
