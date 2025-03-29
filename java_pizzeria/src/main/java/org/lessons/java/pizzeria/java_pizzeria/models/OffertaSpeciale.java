package org.lessons.java.pizzeria.java_pizzeria.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "offerte_speciali")
public class OffertaSpeciale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // implemento la relazione ManyToOne
    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false) // chiave esterna
    private Pizza pizza;

    @Size(min = 5, max = 50, message = "Il titolo deve avere almeno 5 caratteri")
    @Column(name = "titolo", nullable = false)
    @NotBlank(message = "Il campo titolo non può essere vuoto o nullo")
    private String titolo;

    @Column(name = "data_inizio", nullable = false)
    @NotNull(message = "la data d'inizio dell'offerta non può essere null")
    @PastOrPresent
    private LocalDate dataInizio;

    @Column(name = "data_fine", nullable = false)
    @NotNull(message = "la data di fine dell'offerta non può essere null")
    @PastOrPresent
    private LocalDate dataFine;

    // getters e setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.titolo, this.dataInizio, this.dataFine);
    }

}
