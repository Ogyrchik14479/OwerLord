package com.javastart.owerlord.dto;

import com.javastart.owerlord.entity.Planet;

public class PlanetResponseDTO {

    private Long id;

    private String name;

    public PlanetResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlanetResponseDTO(){}

    public PlanetResponseDTO(Planet planet) {
        id = planet.getId();
        name = planet.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
