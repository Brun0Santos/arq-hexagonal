package com.arq.hexagonal.application.ports.out;

import com.arq.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);
}
