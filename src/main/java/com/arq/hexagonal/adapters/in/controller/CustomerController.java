package com.arq.hexagonal.adapters.in.controller;

import com.arq.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        insertCustomerInputPort.insert(customer, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }
}
