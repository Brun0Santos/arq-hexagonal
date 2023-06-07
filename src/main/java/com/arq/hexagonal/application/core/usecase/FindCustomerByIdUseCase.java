package com.arq.hexagonal.application.core.usecase;

import com.arq.hexagonal.application.core.domain.Customer;
import com.arq.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arq.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(Integer id) {
        return findCustomerByIdOutputPort.find(id).orElseThrow(RuntimeException::new);
    }
}
