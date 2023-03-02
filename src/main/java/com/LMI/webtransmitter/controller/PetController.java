package com.LMI.webtransmitter.controller;

import com.LMI.webtransmitter.service.PetService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {
    final String PET_ENDPOINT = "/pet";

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping(PET_ENDPOINT)
    public String getPetRequest(String id) {
        return service.getPetById(id).toString();
    }

    @PostMapping(PET_ENDPOINT)
    public String postPetRequest(String id) {
        return service.createMatildaCatWithId(id).toString();
    }

    @PutMapping(PET_ENDPOINT)
    public String putPetRequest(String id) {
        return service.changePetNameToMatildaById(id).toString();
    }

    @DeleteMapping(PET_ENDPOINT)
    public String deletePetRequest(String id) {
        return service.deletePetById(id).toString();
    }
}
