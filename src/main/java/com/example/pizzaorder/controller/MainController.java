package com.example.pizzaorder.controller;

import com.example.pizzaorder.Dto.Cart;
import com.example.pizzaorder.Dto.Form;
import com.example.pizzaorder.config.AppConfig;
import com.example.pizzaorder.entity.Orders;
import com.example.pizzaorder.entity.State;
import com.example.pizzaorder.repository.OrdersRepository;
import com.example.pizzaorder.repository.PizzaRepository;
import com.example.pizzaorder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController{

    @Autowired
    private AppConfig appconfig;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CartService cartService;

    @RequestMapping("/")
    public String mainRequest(String name, Model model){
        model.addAttribute("pizzas",pizzaRepository.findAll());
        return "main";
    }

    @RequestMapping("/cart")
    public String cartGetRequest(String name, Model model){
        Form form = new Form();
        model.addAttribute("form",form);
        model.addAttribute("cart",cartService.getCart().getPizzas());
        return "cart";

    }

    @RequestMapping("/cart-add/{id}")
    public String addToCart(@PathVariable Long id, Model model){
        cartService.addPizza(id);
        return "redirect:/";
    }

    @RequestMapping("/cart-remove/{id}")
    public String removeFromCart(@PathVariable Long id, Model model){
        cartService.removePizza(id);
        return "redirect:/";
    }

    @RequestMapping("/orders")
    public String ordersRequest(String name, Model model){
        model.addAttribute("order_list",ordersRepository.findAll());
        return "orders";
    }


    @RequestMapping("/prepared/{id}")
    public String preparedRequest(@PathVariable Long id,Model model){
        Optional<Orders> order = ordersRepository.findById(id);
        if(order.isPresent()){
            order.get().setState(State.MADE);
            ordersRepository.save(order.get());
        }
        return "redirect:/orders";
    }

    @RequestMapping("/delivered/{id}")
    public String deliveredRequest(@PathVariable Long id,Model model){
        Optional<Orders> order = ordersRepository.findById(id);
        if(order.isPresent()){
            order.get().setState(State.DELIVERED);
            ordersRepository.save(order.get());
        }
        return "redirect:/orders";
    }


    @RequestMapping("/order_made")
    public String orderMadeRequest(@ModelAttribute("form") Form form, Model model){
        Cart cart = cartService.getCart();
        LocalDateTime date = LocalDateTime.now();
        Orders order = new Orders();
        order.setAddress(form.getAddress());
        order.setName(form.getName());
        order.setPizzas(cart.toString());
        order.setState(State.ORDERED);
        order.setDate(date);
        ordersRepository.save(order);
        return "redirect:/";
    }







}
