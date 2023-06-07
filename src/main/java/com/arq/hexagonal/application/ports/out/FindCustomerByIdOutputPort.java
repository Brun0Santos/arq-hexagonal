package com.arq.hexagonal.application.ports.out;

import com.arq.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(Integer id);
}
