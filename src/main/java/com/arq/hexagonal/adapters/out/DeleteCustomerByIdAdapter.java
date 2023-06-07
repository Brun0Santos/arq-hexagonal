package com.arq.hexagonal.adapters.out;

import com.arq.hexagonal.adapters.out.repository.CustomerRepository;
import com.arq.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
