package com.javastart.owerlord.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class LordView {

    private Long id;

    private String name;

    private Integer age;

    private List<PlanetView> planets;
}
