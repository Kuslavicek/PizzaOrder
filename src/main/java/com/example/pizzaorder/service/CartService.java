package com.example.pizzaorder.service;

import com.example.pizzaorder.Dto.Cart;
import com.example.pizzaorder.config.AppConfig;
import com.example.pizzaorder.entity.Pizza;
import com.example.pizzaorder.repository.OrdersRepository;
import com.example.pizzaorder.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;
import java.util.Set;

@Service
@Scope(value = WebApplicationContext.SCOPE_APPLICATION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {

    @Autowired
    private PizzaRepository pizzaRepository;

    private Cart cart = AppConfig.newCart();


    public Cart getCart(){
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addPizza(Long id){
        cart.addPizza(id,pizzaRepository);
    }
    public void removePizza(Long id){
        cart.removePizza(id,pizzaRepository);
    }
    public void clearCart(){
        cart.clear();
    }









}
