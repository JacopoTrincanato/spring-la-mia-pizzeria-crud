package org.lessons.java.pizzeria.java_pizzeria.repository;

import org.lessons.java.pizzeria.java_pizzeria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
