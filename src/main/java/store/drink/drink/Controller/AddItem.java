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
@RequestMapping(value = "/AddBeverage")

public class AddItem {

    private final BottleRepository bottleRepository;

    @Autowired
    public AddItem(BottleRepository bottleRepository) {
        this.bottleRepository = bottleRepository;
    }

    // private List<bottle> bottles;

//    public AddItem(List<bottle> bottles) {
//        this.bottles = new ArrayList<>();
//        this.bottles.add(new bottle("1", "cola", "picture", 1, true, 40, 13, "pepsi cola", 30));
//
//    }

    @GetMapping
    public String getItem(Model model) {
        //model.addAttribute("AddBeverage", this.bottles);
        model.addAttribute("AddBeverage", this.bottleRepository.findAll());
        model.addAttribute("bottle", new bottle());
        return "AddBeverage";

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
