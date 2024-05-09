package ru.efimov.shoppinglist.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.efimov.shoppinglist.entity.ShopItem;
import ru.efimov.shoppinglist.entity.User;
import ru.efimov.shoppinglist.exception.InputDataException;
import ru.efimov.shoppinglist.repository.ShoppingItemRepository;
import ru.efimov.shoppinglist.repository.UserRepository;
import ru.efimov.shoppinglist.security.UserAuthService;

import java.security.Principal;
@Slf4j
@AllArgsConstructor
@Controller
public class ShoppingListController {

    private final ShoppingItemRepository repository;
    private final UserRepository userRepository;

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        model.addAttribute("items", repository.findByUserUsername(principal.getName()));
        model.addAttribute("item", new ShopItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShopItem shopItem, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        shopItem.setUser(user);
        repository.save(shopItem);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingItem(@PathVariable("id") Long id, Principal principal) {
        repository.deleteById(id);
        return "redirect:/";
    }
//    private User getUserFromSecurityContext() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        var username = authentication.getName();
//        var user = userAuthService.loadUserByUsername(username);
//        if (user != null) {
//            User userResult = new User();
//            userResult.setUsername(user.getUsername());
//            userResult.setPassword(user.getPassword());
//            return userResult;
//        } else {
//            log.error(String.format("User with username %s is not found", username));
//            throw new InputDataException(String.format("User with username %s is not found", username));
//        }
//    }
}
