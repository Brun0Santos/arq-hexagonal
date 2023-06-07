package com.arq.hexagonal.adapters.in.controller;

import com.arq.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arq.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.arq.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arq.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arq.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        insertCustomerInputPort.insert(customer, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") Integer id) {
        var customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id,
                                       @RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipcode());
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
