package com.spring.demo.vehicule.repository.utilisateur;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.demo.vehicule.model.phone.Peripherique;



@Repository
public interface PeripheriqueRepository extends JpaRepository<Peripherique, Integer>{

    void deleteByToken(String token);
    @Query(value = "SELECT * FROM peripherique WHERE token=:token",nativeQuery = true)
    Peripherique getInstanceByToken(@Param("token") String token);
    @Query(value = "SELECT * FROM peripherique WHERE iduser=:iduser",nativeQuery = true)
    List<Peripherique> getInstanceByIduser(@Param("iduser") Integer iduser);
}
