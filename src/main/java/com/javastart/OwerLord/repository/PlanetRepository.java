package com.javastart.OwerLord.repository;

import com.javastart.OwerLord.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
