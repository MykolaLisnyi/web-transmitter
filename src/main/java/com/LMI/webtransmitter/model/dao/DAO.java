package com.LMI.webtransmitter.model.dao;

import com.LMI.webtransmitter.model.Pet;

public interface DAO {

    public Pet copyPetFromSwaggerToDBById(String query);
    public Pet getPetFromDBById(String query);
    public Pet deletePetInDBById(String query);
}

