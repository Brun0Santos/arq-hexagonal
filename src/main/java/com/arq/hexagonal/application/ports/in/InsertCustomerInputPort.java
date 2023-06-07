package com.arq.hexagonal.application.ports.in;

import com.arq.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipcode);
}
