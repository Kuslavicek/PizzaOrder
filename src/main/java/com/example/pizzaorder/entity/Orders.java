package com.example.pizzaorder.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity(name="Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column
    private State state;

    private String pizzas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Enumerated(EnumType.STRING)
    public State getState() {
        return state;
    }

    @Enumerated(EnumType.STRING)
    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPizzas() {
        return pizzas;
    }

    public void setPizzas(String pizzas) {
        this.pizzas = pizzas;
    }
}
