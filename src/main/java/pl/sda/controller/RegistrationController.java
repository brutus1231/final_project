package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.bussiness.UserBoImpl;

@Controller
public class RegistrationController {

    @Autowired
    private UserBoImpl userBo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute(name = "saveButton") String button) {
        userBo.saveUser();
        return "registration";
    }

}