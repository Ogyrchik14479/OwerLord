package com.javastart.owerlord.controller;

import com.javastart.owerlord.dto.PlanetRequestDTO;
import com.javastart.owerlord.dto.PlanetResponseDTO;
import com.javastart.owerlord.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping("/planets")
    public Long createPlanet(@RequestBody PlanetRequestDTO planetRequestDTO) {
        return planetService.addPlanet(planetRequestDTO.getName());
    }

    @GetMapping("planets/{id}")
    public PlanetResponseDTO getPlanet(@PathVariable Long id) {
        System.out.println(planetService.getPlanetById(id).getLord().toString());
        return new PlanetResponseDTO(planetService.getPlanetById(id));
    }

    @GetMapping("/planets")
    public List<PlanetResponseDTO> getAllPlanet() {
        return planetService.getAll()
                .stream()
                .map(PlanetResponseDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/planets/{idPlanet}")
    public void destroyPlanet (@PathVariable Long idPlanet){
        planetService.destroyPlanet(idPlanet);
    }
}
