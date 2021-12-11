package com.javastart.owerlord.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlanetCreateRequest {

    @NotBlank(message = "The name of the planet must not be empty")
    private String name;
}
