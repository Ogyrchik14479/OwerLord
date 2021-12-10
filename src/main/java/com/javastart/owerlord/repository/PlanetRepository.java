package com.javastart.owerlord.repository;

import com.javastart.owerlord.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
