package com.arq.hexagonal.adapters.out.repository;

import com.arq.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Optional<Customer> find(Integer id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> modelMapper.map(entity, Customer.class));
    }
}
