package pl.sda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPanelController {

    @GetMapping("/userPanel")
    public String page() {
        return "userPanel";
    }
}
