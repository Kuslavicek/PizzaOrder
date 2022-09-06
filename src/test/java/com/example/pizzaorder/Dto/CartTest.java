package com.example.pizzaorder.Dto;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


public class CartTest {

    private Cart cart = new Cart();
/*
    @Test
    public void cartTest_1(){
        NoSuchElementException thrown = Assertions.assertThrows(NoSuchElementException.class, () -> {

        });

    }
*/
    @Test
    public void cartTest_2(){
        /*
        cart.addPizza("Salám");
        cart.addPizza("salám");
        Assertions.assertEquals(2,cart.count("salám"));
        */
    }




    @AfterEach
    public void clear(){
        cart.clear();
    }





}
