package com.javastart.owerlord.service;

import com.javastart.owerlord.entity.Planet;
import com.javastart.owerlord.repository.PlanetRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository planetRepository;

    public Optional<Planet> getPlanetById(long id) {
        return planetRepository.findById(id);
    }

    public Long addPlanet(Planet planet) {
        return planetRepository.save(planet).getId();
    }

    public List<Planet> getAll() {
        return planetRepository.findAll();
    }

    public void destroyPlanet(Long planetId) {
        planetRepository.deleteById(planetId);
    }
}
