package com.javastart.owerlord.mapper;

import com.javastart.owerlord.dto.request.PlanetCreateRequest;
import com.javastart.owerlord.dto.response.PlanetView;
import com.javastart.owerlord.entity.Planet;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanetMapper {

    PlanetView convert(Planet lord);

    List<PlanetView> convert(List<Planet> lord);

    Planet convert(PlanetCreateRequest planetCreateRequest);
}
