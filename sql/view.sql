create or replace view v_marque_model as 
select 
    mo.id_model, mo.marque_id, m.marque, an.id_anneesortie, an.annee,
    ca.id_categorie, ca.categorie, mo.model
from marque m
join model mo on mo.marque_id = m.id_marque
join anneesortie an  on an.model_id = mo.id_model
join categorie ca on ca.id_categorie =  mo.categorie_id;

CREATE VIEW v_model_details AS
SELECT
    ma.id_marque,
    ma.marque,
    m.id_model,
    m.model,
    c.id_categorie,
    c.categorie
FROM
    model m
    JOIN marque ma ON m.marque_id = ma.id_marque
    JOIN categorie c ON m.categorie_id = c.id_categorie
    order by ma.id_marque, m.id_model, c.id_categorie;

create view v_model_annee as 
select 
    m.id_marque,
    m.marque,
    m.id_model,
    m.model,
    m.id_categorie,
    m.categorie,
    an.id_anneesortie,
    an.annee 
from 
    v_model_details m
    join anneesortie an on an.model_id = m.id_model 
    order by m.id_marque, m.id_model, m.id_categorie, an.id_anneesortie; 


create or replace view v_categorie_marque as
select 
    id_marque, marque, id_categorie, categorie 
from v_model_details 
    group by id_marque, marque, id_categorie, categorie 
    order by id_marque, id_categorie;

create view v_detail_annonce as 
select 
    annonce.id_annonce, 
    concat(utilisateur.nom, ' ', utilisateur.prenom) as auteur,
    lieu.lieu,
    annonce.prix_vente,
    annonce.date_annonce,
    voiture.matricule,
    voiture.kilometrage,
    marque.marque,
    categorie.categorie,
    annee,
    carburant
from 
    annonce
    join utilisateur on utilisateur.id_utilisateur = annonce.vendeur_id
    join lieu on lieu.id_lieu = annonce.lieu_id
    join voiture on annonce.voiture_id = voiture.id_voiture
    join model on voiture.model_id = model.id_model
    join marque on model.marque_id = marque.id_marque
    join categorie on model.categorie_id = categorie.id_categorie
    join anneesortie on voiture.anneesortie_id = anneesortie.id_anneesortie
    join modelcarburant on voiture.modelcarburant_id = modelcarburant.id_modelcarburant
    join carburant on carburant.id_carburant = modelcarburant.carburant_id;

