package com.spring.demo.vehicule.service.annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.vehicule.model.annonce.Annonce;
import com.spring.demo.vehicule.model.annonce.Favori;
import com.spring.demo.vehicule.model.annonce.Statistique;
import com.spring.demo.vehicule.model.categorie.Categorie;
import com.spring.demo.vehicule.repository.annonce.AnnonceRepository;
import com.spring.demo.vehicule.repository.categorie.CategorieRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;


    @Autowired
    private CategorieRepository categorieRepository;
    public List<Annonce> getAnnoncesNonVendues() {
        return annonceRepository.findByStatusAndEstValide(0, 1);
    }

    public List<Annonce> getAnnoncesByProprietaire(int propietaire) {
        return annonceRepository.findByProp(propietaire);
    }
    
    public List<Annonce> getAnnoncesByFavoris(int user) {
        return annonceRepository.findByFavoris(user);
    }


    public List<Annonce> getAnnoncesNonValide() {
        return annonceRepository.findByEstValide(0);
    }

    public List<Annonce> getAnnoncesValide() {
        return annonceRepository.findByEstValide(1);
    }
    
    public List<Annonce> getByCategorieAndMarque(Annonce annonce) {
        return annonceRepository.getByCategorieAndMarque(annonce.getCategorie(),annonce.getMarque());
    }
    public List<Annonce> search(String min,String max,Annonce a){
        List<Annonce> all = getByCategorieAndMarque(a);
        List<Annonce> rep = new ArrayList<>();
        for (Annonce annonce : all) {
            if(Double.parseDouble(min) <= annonce.getPrix() &&  annonce.getPrix() <= Double.parseDouble(max)){
                rep.add(annonce);
            }
        }
        return rep;
    }

    public Annonce insertAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public void update(String id, Annonce updatedAnnonce) {
        Annonce existingAnnonce = annonceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Annonce non trouvée avec l'ID : " + id));

        existingAnnonce.setTitre(updatedAnnonce.getTitre());
        existingAnnonce.setDescription(updatedAnnonce.getDescription());
        existingAnnonce.setCategorie(updatedAnnonce.getCategorie());
        existingAnnonce.setMarque(updatedAnnonce.getMarque());
        existingAnnonce.setPrix(updatedAnnonce.getPrix());
        existingAnnonce.setDateAjout(updatedAnnonce.getDateAjout());
        existingAnnonce.setDateVente(updatedAnnonce.getDateVente());
        existingAnnonce.setStatus(updatedAnnonce.getStatus());
        existingAnnonce.setImage(updatedAnnonce.getImage());
        existingAnnonce.setProp(updatedAnnonce.getProp());
        existingAnnonce.setFavoris(updatedAnnonce.getFavoris());
        existingAnnonce.setEstValide(updatedAnnonce.getEstValide());

        annonceRepository.save(existingAnnonce);
    }
    public void addFavoris(String idannonce,int id) {
        Annonce existingAnnonce = annonceRepository.findById(idannonce)
                .orElseThrow(() -> new NoSuchElementException("Annonce non trouvée avec l'ID : " + id));

        Favori favori = new Favori();
        favori.setIduser(id);

        existingAnnonce.getFavoris().add(favori);

        annonceRepository.save(existingAnnonce);
    }
    

    public List<Statistique> getAllStatistique()throws Exception{
        List<Categorie> listCateg = categorieRepository.findAll();
        List<Statistique> listStatistique = new ArrayList<>();
        List<Annonce> annonceByCateg = new ArrayList<>();
        double countAnnonceByCategorie = 0;
        double countAnnonceValide = this.getAnnoncesValide().size();
        for (int i = 0; i < listCateg.size(); i++) {
            Statistique statistique = new Statistique();
            annonceByCateg = annonceRepository.findByCategorie(listCateg.get(i).getId().toString());
            countAnnonceByCategorie = annonceByCateg.size();
            statistique.setCategorie(listCateg.get(i));
            statistique.setEffectif((countAnnonceByCategorie*100)/countAnnonceValide);
            listStatistique.add(statistique);
        }
        return listStatistique;
    }

    public Annonce findById(String id) throws Exception{
        Optional<Annonce> optionalAnnonce = annonceRepository.findById(id);

        if (optionalAnnonce.isPresent()) {
            return optionalAnnonce.get();
        } else {
            throw new EntityNotFoundException("Annonce non trouvée avec l'ID : " + id);
        }
    }
    
}

