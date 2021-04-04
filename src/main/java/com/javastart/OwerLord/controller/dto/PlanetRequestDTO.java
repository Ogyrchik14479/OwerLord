package com.javastart.OwerLord.controller.dto;

public class PlanetRequestDTO {

    private String name;

    public PlanetRequestDTO(){}

    public PlanetRequestDTO(String name, Integer age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
