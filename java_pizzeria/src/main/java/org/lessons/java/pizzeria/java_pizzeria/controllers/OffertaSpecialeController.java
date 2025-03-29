package org.lessons.java.pizzeria.java_pizzeria.controllers;

import org.lessons.java.pizzeria.java_pizzeria.models.OffertaSpeciale;
import org.lessons.java.pizzeria.java_pizzeria.repository.OffertaSpecialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaSpecialeController {

    @Autowired
    private OffertaSpecialeRepository repository;

    // rotta store
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offertaSpeciale") OffertaSpeciale offertaSpecialeForm,
            BindingResult bindingResult, Model model) {

        // controllo che la verifica sia avvenuta correttamente
        if (bindingResult.hasErrors()) {
            return "offerte_speciali/create-or-edit";
        }

        // salvo i dati del form
        repository.save(offertaSpecialeForm);

        // reindirizzo alla pagina della singola pizza
        return "redirect:/pizze/" + offertaSpecialeForm.getPizza().getId();
    }

    // metodo edit da compilare
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("offerta", repository.findById(id).get());

        model.addAttribute("edit", true);

        return "offerte_speciali/create-or-edit";
    }

    // metodo che restituisce un update con validazione
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("offertaSpeciale") OffertaSpeciale offertaSpecialeForm,
            BindingResult bindingResult, Model model) {

        // controllo che la verifica sia avvenuta correttamente
        if (bindingResult.hasErrors()) {
            return "offerte_speciali/create-or-edit";
        }

        // salvo i dati del form
        repository.save(offertaSpecialeForm);

        // reindirizzo alla pagina della singola pizza
        return "redirect:/pizze/" + offertaSpecialeForm.getPizza().getId();
    }
}
