package com.challengeliteralura.challengeLiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    private final HttpClient client;

    public ConsumoApi() {
        this.client = HttpClient.newHttpClient();
    }

    public String obtenerDatos(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consumir la API: " + e.getMessage());
        }
    }
}
