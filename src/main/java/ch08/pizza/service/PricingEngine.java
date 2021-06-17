package ch08.pizza.service;

import ch08.pizza.domain.Order;

public interface PricingEngine {
    public float calculateOrderTotal(Order order);
}
