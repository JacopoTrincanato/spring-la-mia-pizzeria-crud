package org.lessons.java.pizzeria.java_pizzeria.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzeria")
public class Pizza {
    // attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 15, message = "Il nome della pizza deve avere almeno 5 caratteri")
    @Column(name = "nome_pizza", nullable = false)
    @NotBlank(message = "Il campo nome non può essere vuoto o nullo")
    private String nome;

    @Lob
    @Column(name = "descrizione_pizza", nullable = false)
    @NotBlank(message = "Il campo descrizione non può essere vuoto o nullo")
    private String descrizione;

    @Lob
    @Column(name = "foto_pizza", nullable = false)
    @NotBlank(message = "Il campo foto non può essere vuoto o nullo")
    private String urlFoto;

    @Column(name = "prezzo_pizza", nullable = false)
    @NotBlank(message = "Il campo prezzo non può essere vuoto o nullo")
    @Min(value = 0, message = "Il prezzo non può avere un valor einferiore a zero")
    private BigDecimal prezzo;

    // metodi
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUrlFoto() {
        return this.urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
