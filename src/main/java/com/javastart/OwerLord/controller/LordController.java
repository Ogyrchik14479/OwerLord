package com.javastart.OwerLord.controller;

import com.javastart.OwerLord.service.LordService;
import com.javastart.OwerLord.controller.dto.LordRequestDTO;
import com.javastart.OwerLord.controller.dto.LordResponseDTO;
import com.javastart.OwerLord.entity.Lord;
import com.javastart.OwerLord.entity.Planet;
import com.javastart.OwerLord.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class LordController {
    
    private final LordService lordService;
    private final PlanetService planetService;

    @Autowired
    public LordController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @PostMapping("/lords")
    public Long createLord(@RequestBody LordRequestDTO lordRequestDTO) {
        return lordService.addLord(lordRequestDTO.getName(), lordRequestDTO.getAge());
    }

    @GetMapping("lords/{id}")
    public LordResponseDTO getLord(@PathVariable Long id) {
        System.out.println(lordService.getLordById(id).toString());
        return new LordResponseDTO(lordService.getLordById(id));
    }

    @GetMapping("/lords")
    public List<LordResponseDTO> getAllLords() {
        return lordService.getAll()
                .stream()
                .map(LordResponseDTO::new)
                .collect(Collectors.toList());
    }

    @PutMapping ("/lordPlanet/{idLord}/{idPlanet}")
    public void addPlanetToLord(@PathVariable Long idLord, @PathVariable Long idPlanet) {
        Planet planet = planetService.getPlanetById(idPlanet);
        lordService.addPlanetToLord(idLord, planet);
    }

    @GetMapping("/loafers")
    public List<LordResponseDTO> getAllLoafers() {
        return lordService.getAll()
                .stream()
                .filter(x -> x.getPlanets().isEmpty())
                .map(LordResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/topLords")
    public List<LordResponseDTO> getSortedLords() {
        return lordService.getAll()
                .stream()
                .sorted(Comparator.comparing(Lord::getAge))
                .limit(10)
                .map(LordResponseDTO::new)
                .collect(Collectors.toList());
    }

}
