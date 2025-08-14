package com.challengeliteralura.challengeLiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosLibro {

    private String title;
    private List<DatosAutor> authors;

    @JsonProperty("languages")
    private List<String> idiomas;

    @JsonProperty("download_count")
    private Integer numeroDescargas;

    public String getTitle() {
        return title;
    }

    public List<DatosAutor> getAuthors() {
        return authors;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }
}
