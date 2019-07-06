package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.bussiness.AuctionBoImpl;
import pl.sda.util.AuthorizationUtil;

@Controller
public class HomeController {

    private AuctionBoImpl auctionBo;
    private AuthorizationUtil authorizationUtil;

    @Autowired
    public HomeController(AuctionBoImpl auctionBo, AuthorizationUtil authorizationUtil) {
        this.auctionBo = auctionBo;
        this.authorizationUtil = authorizationUtil;
    }

    @GetMapping("/index")
    public String home(Model model) {
        String username = authorizationUtil.getUsername();
        model.addAttribute("userAuctions", auctionBo.findByUsername(username));
        return "index";
    }

}
