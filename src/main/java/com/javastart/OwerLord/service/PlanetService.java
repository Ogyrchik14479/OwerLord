package com.javastart.OwerLord.service;

import com.javastart.OwerLord.exception.LordNotFoundException;
import com.javastart.OwerLord.exception.NameIsEmptyException;
import com.javastart.OwerLord.entity.Planet;
import com.javastart.OwerLord.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;


    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet getPlanetById(long id) {
        return planetRepository.findById(id)
                .orElseThrow(() -> new LordNotFoundException("Planet can't find by id :" + id));
    }

    public Long addPlanet(String name) {
        name = name.trim();
        if (name.isEmpty()) throw new NameIsEmptyException("Name Planet can't be empty");

        Planet planet = new Planet(name);
        return planetRepository.save(planet).getId();
    }

    public List<Planet> getAll() {
        return planetRepository.findAll();
    }

    public void destroyPlanet(Long planetId) {
        getPlanetById(planetId).setLord(null);
        planetRepository.deleteById(planetId);
    }
}
