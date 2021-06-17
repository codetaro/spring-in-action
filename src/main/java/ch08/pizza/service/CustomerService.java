package ch08.pizza.service;

import ch08.pizza.domain.Customer;

public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}
