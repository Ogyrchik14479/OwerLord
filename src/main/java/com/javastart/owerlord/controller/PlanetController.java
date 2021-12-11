package com.javastart.owerlord.controller;

import com.javastart.owerlord.dto.request.PlanetCreateRequest;
import com.javastart.owerlord.dto.response.PlanetView;
import com.javastart.owerlord.exception.EntityNotFoundException;
import com.javastart.owerlord.mapper.PlanetMapper;
import com.javastart.owerlord.service.PlanetService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    private final PlanetMapper planetMapper;

    @PostMapping("/planets")
    public Long createPlanet(@RequestBody @Valid PlanetCreateRequest planetCreateRequest) {
        return planetService.addPlanet(planetMapper.convert(planetCreateRequest));
    }

    @GetMapping("planets/{id}")
    public PlanetView getPlanet(@PathVariable Long id) {
        return planetMapper.convert(planetService.getPlanetById(id)
                .orElseThrow(() -> new EntityNotFoundException("Planet can't find by id = ", id)));
    }

    @GetMapping("/planets")
    public List<PlanetView> getAllPlanet() {
        return planetMapper.convert(planetService.getAll());

    }

    @DeleteMapping("/planets/{idPlanet}")
    public void destroyPlanet(@PathVariable Long idPlanet) {
        planetService.destroyPlanet(idPlanet);
    }
}
