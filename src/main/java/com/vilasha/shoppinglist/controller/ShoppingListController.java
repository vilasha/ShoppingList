package com.vilasha.shoppinglist.controller;

import com.vilasha.shoppinglist.persist.ItemRepository;
import com.vilasha.shoppinglist.persist.ShoppingItem;
import com.vilasha.shoppinglist.persist.User;
import com.vilasha.shoppinglist.persist.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ShoppingListController {

    private final ItemRepository repository;
    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(ShoppingListController.class);

    @Autowired
    public ShoppingListController(ItemRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        log.info("User name: {}", principal.getName());
        model.addAttribute("items", repository.findByUserUsername(principal.getName()));
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String addNewItem(ShoppingItem item, Principal principal) {
        log.info("User name: {}", principal.getName());
        User user = userRepository.findByUsername(principal.getName()).get();
        item.setUser(user);
        repository.save(item);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
