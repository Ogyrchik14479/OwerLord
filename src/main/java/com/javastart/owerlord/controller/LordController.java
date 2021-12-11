package com.javastart.owerlord.controller;

import com.javastart.owerlord.dto.request.LordCreateRequest;
import com.javastart.owerlord.dto.response.LordView;
import com.javastart.owerlord.entity.Lord;
import com.javastart.owerlord.exception.EntityNotFoundException;
import com.javastart.owerlord.mapper.LordMapper;
import com.javastart.owerlord.service.LordService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LordController {
    
    private final LordService lordService;

    private final LordMapper lordMapper;

    @PostMapping("/lords")
    public Long createLord(@RequestBody @Valid LordCreateRequest lordCreateRequest) {
        return lordService.addLord(lordMapper.convert(lordCreateRequest));
    }

    @GetMapping("lords/{id}")
    public LordView getLord(@PathVariable Long id) {
        Lord lord = lordService.getLordById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lord can't find by id = ", id));
        return lordMapper.convert(lord);
    }

    @GetMapping("/lords")
    public List<LordView> getAllLords() {
        return lordMapper.convert(lordService.getAll());
    }

    @PutMapping ("/lordPlanet/{idLord}/{idPlanet}")
    public void addPlanetToLord(@PathVariable Long idLord, @PathVariable Long idPlanet) {
        lordService.addPlanetToLord(idLord, idPlanet);
    }

    @GetMapping("/loafers")
    public List<LordView> getAllLoafers() {
        return lordMapper.convert(lordService.getTenTheTopYoungest());
    }

    @GetMapping("/topLords")
    public List<LordView> getSortedLords() {
        return lordMapper.convert(lordService.getTenTheTopYoungest());
    }
}
