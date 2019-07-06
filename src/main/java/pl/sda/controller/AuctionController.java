package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.bussiness.AuctionBoImpl;
import pl.sda.bussiness.CategoryBoImpl;
import pl.sda.dto.AuctionDto;

import javax.validation.Valid;

@Controller
public class AuctionController {

    private static final String AUCTION_REGISTRED_CORRECTLY = "Aukcja zarejestrowana poprawnie";

    @Autowired
    private AuctionBoImpl auctionBo;

    @Autowired
    private CategoryBoImpl categoryBo;

    @GetMapping("/auction")
    public String page(Model model) {
        model.addAttribute("auction", new AuctionDto());
        model.addAttribute("categories", categoryBo.findAll());
        return "auction";
    }

    @PostMapping("/saveAuction")
    public String saveAuction(@Valid @ModelAttribute(name = "auction") AuctionDto auction, BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "auction";
        }

        auctionBo.saveAuction(auction);
        model.addAttribute("auctionRegisteredCorrectly", AUCTION_REGISTRED_CORRECTLY);
        model.addAttribute("categories", categoryBo.findAll());
        return "auction";
    }
}
