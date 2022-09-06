package com.example.pizzaorder.repository;

import com.example.pizzaorder.entity.Orders;
import com.example.pizzaorder.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

    List<Orders> findByState(State state);

}
