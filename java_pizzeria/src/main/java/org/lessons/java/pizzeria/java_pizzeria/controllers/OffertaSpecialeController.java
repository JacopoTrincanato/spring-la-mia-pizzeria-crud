package org.lessons.java.pizzeria.java_pizzeria.controllers;

import org.lessons.java.pizzeria.java_pizzeria.models.OffertaSpeciale;
import org.lessons.java.pizzeria.java_pizzeria.repository.OffertaSpecialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerta")
public class OffertaSpecialeController {

    @Autowired
    private OffertaSpecialeRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offerta") OffertaSpeciale offertaSpecialeForm,
            BindingResult bindingResult, Model model) {

        // controllo che la verifica sia avvenuta correttamente
        if (bindingResult.hasErrors()) {
            return "offerteSpeciali/create";
        }

        // salvo i dati del form
        repository.save(offertaSpecialeForm);

        // reindirizzo alla pagina della singola pizza
        return "redirect:/pizza/" + offertaSpecialeForm.getPizza().getId();
    }
}
