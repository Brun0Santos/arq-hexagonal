package com.arq.hexagonal.adapters.out.client;

import com.arq.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${bruno.client.address.url}")
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipcode}")
    AddressResponse find(@PathVariable("zipcode") String zipcode);

}
