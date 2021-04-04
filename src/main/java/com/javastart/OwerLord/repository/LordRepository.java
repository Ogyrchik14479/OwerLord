package com.javastart.OwerLord.repository;

import com.javastart.OwerLord.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LordRepository extends JpaRepository<Lord, Long> {
}
