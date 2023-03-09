package com.LMI.webtransmitter.jdbc;

public abstract class Query {
    private Query(){
        //hide
    }

    public static final String GET_PET_BY_ID = "SELECT * FROM pets WHERE pets.pet_id = ? LIMIT 1;";
    public static final String DELETE_PET_BY_ID = "DELETE FROM pets WHERE pets.pet_id = ?;";
    public static final String COPY_PET_BY_ID = "INSERT INTO pets VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
}
