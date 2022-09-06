package com.example.pizzaorder.config;

import com.example.pizzaorder.Dto.Cart;
import com.example.pizzaorder.Dto.Form;
import com.example.pizzaorder.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public static Cart newCart(){
        return new Cart();
    }


    @Bean
    @Scope("session")
    public static Form newForm(){
        return new Form();
    }



}
