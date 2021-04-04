package com.javastart.OwerLord.controller.dto;

import com.javastart.OwerLord.entity.Lord;


import java.util.List;
import java.util.stream.Collectors;

public class LordResponseDTO {

    private Long id;

    private String name;

    private Integer age;


    private List<PlanetResponseDTO> planets;

    public LordResponseDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public LordResponseDTO(Lord lord) {
        id = lord.getId();
        name = lord.getName();
        age = lord.getAge();
        planets = lord.getPlanets().stream().
                map(PlanetResponseDTO::new).
                collect(Collectors.toList());
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<PlanetResponseDTO> getPlanets() {
        return planets;
    }

    public void setPlanets(List<PlanetResponseDTO> planets) {
        this.planets = planets;
    }
}
