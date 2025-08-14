package com.challengeliteralura.challengeLiterAlura.service;

import com.challengeliteralura.challengeLiterAlura.model.Libro;
import com.challengeliteralura.challengeLiterAlura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService{

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}
