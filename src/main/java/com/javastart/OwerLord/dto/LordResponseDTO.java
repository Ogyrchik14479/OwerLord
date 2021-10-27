package com.javastart.OwerLord.dto;

import com.javastart.OwerLord.entity.Lord;


import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
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
}
