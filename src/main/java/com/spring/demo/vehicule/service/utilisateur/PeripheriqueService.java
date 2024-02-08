package com.spring.demo.vehicule.service.utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.vehicule.model.phone.Peripherique;
import com.spring.demo.vehicule.model.utilisateur.Token;
import com.spring.demo.vehicule.repository.utilisateur.PeripheriqueRepository;

import jakarta.transaction.Transactional;

@Service
public class PeripheriqueService {
    private final PeripheriqueRepository peripheriqueRepository;

    @Autowired
    public PeripheriqueService(PeripheriqueRepository tokenRepository) {
        this.peripheriqueRepository = tokenRepository;
    }
    
    public Peripherique createInstance(Peripherique peripherique) {
        return peripheriqueRepository.save(peripherique);
    }
    @Transactional
    public void deleteByToken(Peripherique periph) {
        peripheriqueRepository.deleteByToken(periph.getToken());
    }
    public List<Peripherique> getByIduser(Peripherique periph){
       return  peripheriqueRepository.getInstanceByIduser(periph.getIduser());
    }

}
