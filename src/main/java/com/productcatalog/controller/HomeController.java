package com.productcatalog.controller;

import com.productcatalog.model.Product;
import com.productcatalog.repository.ProductRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping("/")
        public String home(Model model) {

                List<Product> productList = productRepository.findAll();

                ArrayList result = new ArrayList();

                for (Product product : productList) {
                        JSONObject obj = new JSONObject();

                        obj.put("id", product.getId());
                        obj.put("code", product.getCode());
                        obj.put("name", product.getName());
                        obj.put("category", product.getCategory());
                        obj.put("brand", product.getBrand());
                        obj.put("type", product.getType());
                        obj.put("description", product.getDescription());
                        result.add(obj);
                }

                model.addAttribute("products", result);

                return "index";
        }

}
