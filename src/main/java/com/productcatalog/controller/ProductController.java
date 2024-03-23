package com.productcatalog.controller;

import com.productcatalog.model.Product;
import com.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping("/add")
        public String showAddPage() {
                return "product-add";
        }

        @PostMapping("/processAddProduct")
        public ModelAndView processAddProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){

                ModelAndView modelAndView = new ModelAndView();

                boolean isProductExists = productRepository.findByName(product.getName()) != null;

                if (isProductExists) {
                        redirectAttributes.addFlashAttribute("message", "failed");
                } else {
                        productRepository.save(product);
                        redirectAttributes.addFlashAttribute("message", "success");
                }

                modelAndView.setViewName("redirect:/");

                return modelAndView;
        }

        @GetMapping("/delete/{id}")
        public ModelAndView deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
                ModelAndView modelAndView = new ModelAndView();

                productRepository.deleteById(id);
                redirectAttributes.addFlashAttribute("message", "deleted");

                modelAndView.setViewName("redirect:/");

                return modelAndView;
        }

        @GetMapping("/edit/{id}")
        public ModelAndView showEditPage(@PathVariable("id") int id, Model model) {
                ModelAndView modelAndView = new ModelAndView();

                Product product = productRepository.findById(id).get();

                model.addAttribute("product", product);

                modelAndView.setViewName("product-edit");

                return modelAndView;
        }

        @PostMapping("/processEditProduct")
        public ModelAndView processEditProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
                ModelAndView modelAndView = new ModelAndView();

                //update the data by id
                System.out.println("id: " + product.getId());
                int updateProduct = productRepository.updateById(product.getId(), product.getCode(), product.getName(), product.getCategory(), product.getBrand(), product.getType(), product.getDescription());

                if (updateProduct == 0) {
                        redirectAttributes.addFlashAttribute("message", "failedUpdate");
                } else {
                        redirectAttributes.addFlashAttribute("message", "updated");
                }

                modelAndView.setViewName("redirect:/");

                return modelAndView;
        }

}
