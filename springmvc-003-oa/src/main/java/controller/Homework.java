package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homework")
public class Homework {
    @GetMapping
    public String add(Double num1, Double num2, Model model){
        double result=num1+num2;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result",result);
        return "forward:/jsp/result.jsp";
    }
}