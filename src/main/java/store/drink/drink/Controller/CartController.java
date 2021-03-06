package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Modal.bottle;
import store.drink.drink.repository.BottleRepository;

@Controller
@RequestMapping(value = "Cart")
public class CartController {
    private final BottleRepository bottleRepository;

    @Autowired
    public CartController(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    @GetMapping
    public String getItem(Model model) {
        //model.addAttribute("AddBeverage", this.bottles);
        model.addAttribute("AddBeverage", this.bottleRepository.findAll());
        model.addAttribute("bottle", new bottle());
        return "Cart";

    }

//    @PostMapping
//    public String postItem(bottle bottle, Model model) {
//
//        this.bottleRepository.save(bottle);
//
//        return "redirect:/Cart";
//    }
}
