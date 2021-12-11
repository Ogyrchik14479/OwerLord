package com.javastart.owerlord.repository;

import com.javastart.owerlord.entity.Lord;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LordRepository extends JpaRepository<Lord, Long> {

    @Query("FROM Lord l ORDER BY l.age")
    List<Lord> findTheTopYoungest(Pageable pageable);
}
