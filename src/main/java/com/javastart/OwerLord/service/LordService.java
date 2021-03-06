package com.javastart.OwerLord.service;

import com.javastart.OwerLord.entity.Lord;
import com.javastart.OwerLord.entity.Planet;
import com.javastart.OwerLord.exception.IncorrectSetAgeException;
import com.javastart.OwerLord.exception.LordNotFoundException;
import com.javastart.OwerLord.exception.NameIsEmptyException;
import com.javastart.OwerLord.repository.LordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LordService {

    private final LordRepository lordRepository;

    @Autowired
    public LordService(LordRepository lordRepository) {
        this.lordRepository = lordRepository;
    }

    public Long addLord(String name, Integer age) {
        name = name.trim();
        if (name.isEmpty())
            throw new NameIsEmptyException("The name of the lord must not be empty");
        if (age == null || age <= 0)
            throw new IncorrectSetAgeException("The age of the lord must not be empty and must be greater than 0");

        Lord lord = new Lord(name, age);
        return lordRepository.save(lord).getId();
    }

    public Lord getLordById(long id) {
        return lordRepository.findById(id)
                .orElseThrow(() -> new LordNotFoundException("Lord can't find by id :" + id));
    }

    public void addPlanetToLord(Long idLord, Planet planet) {
        Lord lord = getLordById(idLord);
        lord.addPlanetToLord(planet);
        lordRepository.save(lord);
    }

    public List<Lord> getAll() {
        return lordRepository.findAll();
    }
}
