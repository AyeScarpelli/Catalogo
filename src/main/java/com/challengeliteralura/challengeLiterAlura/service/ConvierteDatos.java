package com.challengeliteralura.challengeLiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class ConvierteDatos {

    private ObjectMapper objectMapper;

    public ConvierteDatos() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {throw new RuntimeException("Error al convertir JSON a objeto: " + e.getMessage(), e);
        }
    }

    public <T> List<T> obtenerListaDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clase));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir JSON a lista de objetos: " + e.getMessage(), e);
        }
    }
}
