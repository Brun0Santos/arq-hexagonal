package com.arq.hexagonal.adapters.out.client.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressResponseMapper {

    @Bean
    public ModelMapper toAddress() {
        return new ModelMapper();
    }
}
