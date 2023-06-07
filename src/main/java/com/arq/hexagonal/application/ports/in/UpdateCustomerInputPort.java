package com.arq.hexagonal.application.ports.in;

import com.arq.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
