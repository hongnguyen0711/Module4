package com.example.product.controller;

import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
@Autowired
    private IProductService productService;
}
