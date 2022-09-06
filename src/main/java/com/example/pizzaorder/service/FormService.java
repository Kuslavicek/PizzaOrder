package com.example.pizzaorder.service;

import com.example.pizzaorder.Dto.Form;
import com.example.pizzaorder.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Service
public class FormService {

    private Form form = AppConfig.newForm();

}
