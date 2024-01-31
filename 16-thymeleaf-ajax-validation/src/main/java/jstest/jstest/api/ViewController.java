package jstest.jstest.api;

import jstest.jstest.entity.Homie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/validationTesting")
    public String testowanie(Model theModel){

        theModel.addAttribute("homie",new Homie());

        return "validation-testing";
    }



}
