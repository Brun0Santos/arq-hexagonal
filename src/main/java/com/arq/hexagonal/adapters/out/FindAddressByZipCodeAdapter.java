package com.arq.hexagonal.adapters.out;

import com.arq.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.arq.hexagonal.application.core.domain.Address;
import com.arq.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return mapper.map(addressResponse, Address.class);
    }
}
