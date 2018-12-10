package com.mk.controller;

import com.mk.model.Product;
import com.mk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by shakeelosmani on 24/12/16.
 */

@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;


    @RequestMapping("/product/{productId}")
    public String product(@PathVariable Long productId, Model model){
        model.addAttribute("product", productRepository.findOne(productId));
        return "product";
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public String productsList(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product.getProductId().toString();
    }

}
