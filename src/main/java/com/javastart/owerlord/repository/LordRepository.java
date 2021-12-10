package com.javastart.owerlord.repository;

import com.javastart.owerlord.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LordRepository extends JpaRepository<Lord, Long> {
}
