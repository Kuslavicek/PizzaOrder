package com.example.pizzaorder.repository;

import com.example.pizzaorder.entity.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class RepositoryTest {

    /*private Pizza hamPizza = new Pizza();
    private Pizza olivePizza = new Pizza();
    private Pizza cheesePizza = new Pizza();

    private PizzaOrder hamFive = new PizzaOrder();
    private PizzaOrder cheeseThree = new PizzaOrder();
    private PizzaOrder oliveOne = new PizzaOrder();

    private Orders hamPlusCheese = new Orders();
    private Orders oliveOrder = new Orders();
    private Set<PizzaOrder> hamPlusCheeseList= Set.of(hamFive,cheeseThree);
    private Set<PizzaOrder> oliveList= Set.of(oliveOne);

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private OrdersRepository ordersRepository;


    @BeforeEach
    void init(){
        hamPizza.setType("Ham");
        olivePizza.setType("Olive");
        cheesePizza.setType("Cheese");
        hamFive.setType("Ham");
        hamFive.setAmount(5);
        cheeseThree.setType("Cheese");
        cheeseThree.setAmount(3);
        oliveOne.setType("Olive");
        oliveOne.setAmount(1);
        hamPlusCheese.setOrders(hamPlusCheeseList);
        oliveOrder.setOrders(oliveList);


    }


    @Test
    void pizzaRepositoryTest(){


        pizzaRepository.save(olivePizza);
        pizzaRepository.save(hamPizza);
    }

    @Test
    void pizzaOrderRepositoryTest(){
        pizzaOrderRepository.save(hamFive);
        pizzaOrderRepository.save(cheeseThree);
    }

    @Test
    void orderListRepositoryTest(){
        ordersRepository.save(hamPlusCheese);
        ordersRepository.save(oliveOrder);
    }*/

}
