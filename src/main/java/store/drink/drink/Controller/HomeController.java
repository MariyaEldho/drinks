package store.drink.drink.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Modal.bottle;
import store.drink.drink.repository.BottleRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "Home")

public class HomeController {
    private final BottleRepository bottleRepository;

    @Autowired
    public HomeController(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    @GetMapping
    public String getItem(@Valid bottle bottle, Errors errors, Model model) {
        //model.addAttribute("AddBeverage", this.bottles);
        model.addAttribute("AddBeverage", this.bottleRepository.findAll());
        model.addAttribute("bottle", new bottle());
        return "Home";

    }

    @PostMapping
    public String postItem(@Valid bottle bottle, Errors errors, Model model) {
        if (errors.hasErrors()) {
            //model.addAttribute("AddBeverage", this.bottles);
            model.addAttribute("AddBeverage", this.bottleRepository.findAll());
            return "AddBeverage";
        }
        bottle.setId("m" + (this.bottleRepository.count() + 1));
        // bottle.setId("" + (this.bottles.size() + 1));
        //  this.bottles.add(bottle);
        this.bottleRepository.save(bottle);
        return "redirect:/Home";
    }
}
