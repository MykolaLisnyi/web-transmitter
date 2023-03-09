package com.LMI.webtransmitter.controller;

import com.LMI.webtransmitter.model.dao.DAO;
import com.LMI.webtransmitter.model.dao.PetDAO;
import com.LMI.webtransmitter.service.PetService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {
    final String PET_WEB_ENDPOINT = "/pet";
    final String PET_DB_ENDPOINT = "/pet/{petId}";

    private final PetService service;
    private DAO dao = new PetDAO();

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping(path = PET_DB_ENDPOINT)
    public String getPetFromDBById(@PathVariable String petId) {
        return dao.getPetFromDBById(petId).toString();
    }

    @PostMapping(path = PET_DB_ENDPOINT)
    public String createPetInDBById(@PathVariable String petId) {
        return dao.copyPetFromSwaggerToDBById(petId).toString();
    }

    @DeleteMapping(path = PET_DB_ENDPOINT)
    public String deletePetFromDBById(@PathVariable String petId) {
        return dao.deletePetInDBById(petId).toString();
    }


    @GetMapping(PET_WEB_ENDPOINT)
    public String getPetRequest(String id) {
        return service.getPetById(id).toString();
    }

    @PostMapping(PET_WEB_ENDPOINT)
    public String postPetRequest(String id) {
        return service.createMatildaCatWithId(id).toString();
    }

    @PutMapping(PET_WEB_ENDPOINT)
    public String putPetRequest(String id) {
        return service.changePetNameToMatildaById(id).toString();
    }

    @DeleteMapping(PET_WEB_ENDPOINT)
    public String deletePetRequest(String id) {
        return service.deletePetById(id).toString();
    }





}
