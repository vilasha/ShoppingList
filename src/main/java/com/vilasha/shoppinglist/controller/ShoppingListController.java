package com.vilasha.shoppinglist.controller;

import com.vilasha.shoppinglist.persist.ItemRepository;
import com.vilasha.shoppinglist.persist.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingListController {

    private final ItemRepository repository;

    @Autowired
    public ShoppingListController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String addNewShoppingItem(ShoppingItem item) {
        repository.save(item);
        return "redirect:/";
    }
}
