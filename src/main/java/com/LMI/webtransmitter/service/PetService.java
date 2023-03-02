package com.LMI.webtransmitter.service;

import com.LMI.webtransmitter.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Service
public class PetService {

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String baseUrl = "https://petstore.swagger.io/v2";
    private final WebClient localApiClient;

    @Autowired
    public PetService() {
        this.localApiClient = WebClient.create(baseUrl);
    }

    public Pet getPetById(String id) {
        return localApiClient
                .get()
                .uri("/pet/" + id)
                .retrieve()
                .bodyToMono(Pet.class)
                .block(REQUEST_TIMEOUT);
    }

    public String createMatildaCatWithId(String id) {
        Integer intId = id.matches("\\d+")
                ? Integer.parseInt(id)
                : 1;

        Pet pet = new Pet.Builder()
                .withId(intId)
                .withName("Matilda-Cat")
                .build();

        return localApiClient
                .post()
                .uri("/pet")
                .bodyValue(pet)
                .retrieve()
                .bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }

    public String changePetNameToMatildaById(String id) {
        Pet pet = getPetById(id);
        pet.setName("Matilda");

        return localApiClient
                .put()
                .uri("/pet")
                .bodyValue(pet)
                .retrieve()
                .bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }

    public String deletePetById(String id) {
        return localApiClient
                .delete()
                .uri("/pet/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block(REQUEST_TIMEOUT);
    }
}
