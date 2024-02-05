package com.spring.demo.vehicule.repository.utilisateur;

import com.spring.demo.vehicule.model.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndMdp(String email, String mdp);
}
