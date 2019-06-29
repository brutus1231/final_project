package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.bussiness.UserBoImpl;
import pl.sda.dto.UserDto;

@Controller
public class RegistrationController {

    @Autowired
    private UserBoImpl userBo;

    @GetMapping("/register")
    public String registration(Model model) {
        initModel(model);
        return "registration";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute UserDto user, Model model) {
        initModel(model);
        userBo.saveUser(user);

        return "login";
    }

    private void initModel(Model model) {
        model.addAttribute("user", new UserDto());
    }

}