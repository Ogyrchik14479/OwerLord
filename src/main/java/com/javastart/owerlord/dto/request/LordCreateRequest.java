package com.javastart.owerlord.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class LordCreateRequest {

    @NotBlank(message = "The name of the lord must not be empty")
    private String name;

    @NotNull(message = "The age of the lord must not be empty")
    @Range(min = 0, max = 1000, message = "The age of the lord must be more than 0 and less than 1000 years")
    private Integer age;
}
