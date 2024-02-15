package com.pb.citizen_api.repository;

import com.pb.citizen_api.dto.LoginResponse;
import com.pb.citizen_api.model.Citizen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen,Long> {

    @Query("SELECT new com.pb.citizen_api.dto.LoginResponse(u.email, u.password) FROM Citizen u WHERE u.email = :username")
    List<LoginResponse> findEmailAndPasswordByEmail(@Param("username") String username);

    Citizen findByEmail(String email);

    Citizen findByName(String name);
}
