package com.nathancai.nfcu.learningspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/home")
    public String home(@RequestParam (name="name", required=false,
            defaultValue="Guest")String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
