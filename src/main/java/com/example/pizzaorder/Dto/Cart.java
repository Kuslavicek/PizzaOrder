package com.example.pizzaorder.Dto;

import com.example.pizzaorder.config.AppConfig;
import com.example.pizzaorder.entity.Pizza;
import com.example.pizzaorder.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class Cart {

    private Map<Pizza, Integer> pizzas;

    public Cart(){
        pizzas=new HashMap<Pizza, Integer>();
    }


    public void clear(){
        pizzas.clear();
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Long id,PizzaRepository pizzaRepository){
            Optional<Pizza> pizza = pizzaRepository.findById(id);
            if(pizza.isPresent()){
                if(findByType(pizza.get().getType(),true)==false) {
                    pizzas.put(pizza.get(), 1);
                }
            }
    }

    public void removePizza(Long id,PizzaRepository pizzaRepository) throws NoSuchElementException {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()){
            findByType(pizza.get().getType(),false);
            }else{
                throw new NoSuchElementException("Pizza "+pizza+" není v košíku");
            }
        }


    public int size(){
        return pizzas.size();
    }

    public int count(Long id,PizzaRepository pizzaRepository){
        return pizzas.get(pizzaRepository.findById(id));
    }


    @Override
    public String toString(){
        String text = "";
        for (Map.Entry<Pizza,Integer> entry : pizzas.entrySet()) {
            text = text + entry.getKey() +" "+ entry.getValue() + "\n";
        }
        return text;
    }

    public boolean findByType(String type,boolean add) {
        boolean find = false;
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            if (entry.getKey().getType().equals(type)) {
                if(add) {
                    entry.setValue(entry.getValue() + 1);
                }else{
                    if(entry.getValue()>=2) {
                        entry.setValue(entry.getValue() - 1);
                    }else{
                        pizzas.remove(entry.getKey());
                    }
                }
                find=true;
                break;
            }
        }
    return find;
    }

}
