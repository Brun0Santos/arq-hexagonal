package com.arq.hexagonal.application.core.usecase;

import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arq.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomersUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomersUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                  InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipcode) {
        var address = findAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }

}
