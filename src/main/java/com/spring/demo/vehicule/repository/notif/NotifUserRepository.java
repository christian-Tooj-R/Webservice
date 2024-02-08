package com.spring.demo.vehicule.repository.notif;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.demo.vehicule.model.notif.NotifUser;

@Repository
public interface NotifUserRepository extends JpaRepository<NotifUser, Integer>{
    @Query(value = "SELECT * FROM notifuser WHERE iduser=:iduser",nativeQuery = true)
    List<NotifUser> getByUser(@Param("iduser") int iduser);
}