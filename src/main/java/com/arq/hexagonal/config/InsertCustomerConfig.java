package com.arq.hexagonal.config;

import com.arq.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arq.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arq.hexagonal.application.core.usecase.InsertCustomersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomersUseCase insertCustomersUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                         InsertCustomerAdapter insertCustomerAdapter) {
        return new InsertCustomersUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
