package com.arq.hexagonal.application.core.domain;

public class Customer {
    private Integer id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String name, Address address, String cpf, Boolean isValidCpf) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }
}
