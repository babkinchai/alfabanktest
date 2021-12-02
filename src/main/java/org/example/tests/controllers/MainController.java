package org.example.tests.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @GetMapping("/url")
    public RedirectView currencyController(
        RedirectAttributes attributes) {
            attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
            attributes.addAttribute("attribute", "redirectWithRedirectView");
            return new RedirectView("https://media4.giphy.com/media/YsTs5ltWtEhnq/giphy.gif?cid=9aece108314c6d0e5ff3eb0da0b22cd3b204e774c47ed880&rid=giphy.gif&ct=g");
    }
}
