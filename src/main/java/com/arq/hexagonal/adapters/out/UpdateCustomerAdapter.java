package com.arq.hexagonal.adapters.out;

import com.arq.hexagonal.adapters.out.repository.CustomerRepository;
import com.arq.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }
}
