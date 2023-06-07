package com.arq.hexagonal.adapters.out;

import com.arq.hexagonal.adapters.out.repository.CustomerRepository;
import com.arq.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }
}
