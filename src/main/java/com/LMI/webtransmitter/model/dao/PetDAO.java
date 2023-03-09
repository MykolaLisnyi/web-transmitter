package com.LMI.webtransmitter.model.dao;

import com.LMI.webtransmitter.jdbc.PetConnector;
import com.LMI.webtransmitter.jdbc.Query;
import com.LMI.webtransmitter.model.Pet;
import com.LMI.webtransmitter.service.PetService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDAO implements DAO {

    private PetConnector con;

    public PetDAO() {
        con = new PetConnector();
    }

    @Override
    public Pet copyPetFromSwaggerToDBById(String petId) {
        Pet pet = new PetService().getPetById(petId);

        if (pet == null)
            return null;

        deletePetInDBById(petId);

        try (PreparedStatement pstmt = con.initPreparedStatement(Query.COPY_PET_BY_ID)) {
            pstmt.setInt(1, pet.getId());
            pstmt.setInt(2, pet.getCategory().getId());
            pstmt.setString(3, pet.getCategory().getName());
            pstmt.setString(4, pet.getName());
            pstmt.setString(5, pet.getPhotoUrls().get(0));
            pstmt.setInt(6, pet.getTags().get(0).getId());
            pstmt.setString(7, pet.getTags().get(0).getName());
            pstmt.setString(8, pet.getStatus());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pet;
    }

    @Override
    public Pet getPetFromDBById(String petId) {
        try (PreparedStatement pstmt = con.initPreparedStatement(Query.GET_PET_BY_ID)) {
            pstmt.setString(1, petId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pet.Builder()
                            .withId(rs.getInt("pet_id"))
                            .withCategoryId(rs.getInt("category_id"))
                            .withCategoryName(rs.getString("category_name"))
                            .withName(rs.getString("pet_name"))
                            .withPhotoUrls(rs.getString("pet_photoUrls"))
                            .withTagsId(rs.getInt("tag_id"))
                            .withTagsName(rs.getString("tag_name"))
                            .withStatus(rs.getString("pet_status"))
                            .build();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Pet deletePetInDBById(String petId) {
        Pet pet = getPetFromDBById(petId);

        if (pet != null)
            pet.setStatus("deleted");

        try (PreparedStatement pstmt = con.initPreparedStatement(Query.DELETE_PET_BY_ID)) {
            pstmt.setString(1, petId);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pet;
    }
}
