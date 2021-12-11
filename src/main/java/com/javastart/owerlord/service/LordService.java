package com.javastart.owerlord.service;

import com.javastart.owerlord.entity.Lord;
import com.javastart.owerlord.entity.Planet;
import com.javastart.owerlord.exception.EntityNotFoundException;
import com.javastart.owerlord.repository.LordRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LordService {

    private final LordRepository lordRepository;

    private final PlanetService planetService;

    public Long addLord(Lord lord) {
        return lordRepository.save(lord).getId();
    }

    public Optional<Lord> getLordById(long id) {
        return lordRepository.findById(id);
    }

    public void addPlanetToLord(Long idLord, Long idPlanet) {
        Planet planet = planetService.getPlanetById(idPlanet)
                .orElseThrow(() -> new EntityNotFoundException("Planet can't find by id = ", idPlanet));

        Lord lord = getLordById(idLord)
                .orElseThrow(() -> new EntityNotFoundException("Lord can't find by id = ", idPlanet));

        lord.getPlanets().add(planet);
        lordRepository.save(lord);
    }

    public List<Lord> getTenTheTopYoungest() {
        return lordRepository.findTheTopYoungest(PageRequest.ofSize(10));
    }

    public List<Lord> getAll() {
        return lordRepository.findAll();
    }
}
