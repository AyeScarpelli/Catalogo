package com.challengeliteralura.challengeLiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaAPI {

    private List<DatosLibro> results;

    public List<DatosLibro> getResults() {
        return results;
    }
}
