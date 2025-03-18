package org.lessons.java.pizzeria.java_pizzeria.controllers;

import java.util.List;

import org.lessons.java.pizzeria.java_pizzeria.models.Pizza;
import org.lessons.java.pizzeria.java_pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    // creo la rotta index
    @GetMapping
    public String index(Model model) {
        // creo la lista di pizze
        List<Pizza> pizze = repository.findAll();

        model.addAttribute("pizze", pizze);

        return "pizze/index";
    }
}
