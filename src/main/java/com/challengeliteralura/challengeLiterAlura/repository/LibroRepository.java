package com.challengeliteralura.challengeLiterAlura.repository;

import com.challengeliteralura.challengeLiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
