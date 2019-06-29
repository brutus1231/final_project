package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.bussiness.UserBoImpl;
import pl.sda.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    private UserBoImpl userBo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute(name = "user") UserDto user) {
        userBo.saveUser(user);

        return "registration";
    }

}