package com.challengeliteralura.challengeLiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosAutor {

    private String name;

    @JsonProperty("birth_year")
    private Integer anioNacimiento;

    @JsonProperty("death_year")
    private Integer anioFallecimiento;

    public String getName() {
        return name;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }
}
