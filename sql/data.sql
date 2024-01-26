-- Insertion dans la table "comission"
INSERT INTO comission (taux) VALUES 
    (5); -- en %

-- Insertion dans la table "utilisateur"
INSERT INTO utilisateur (nom, prenom, genre, date_naissance, email, mdp, roles)
VALUES 
    ('Mr', 'Admin', 1, '1990-01-01', 'admin@example.com', 'root', 10),
    ('RANDRIA', 'Malala', 2, '1985-05-15', 'randria@example.com', '1234', 1),
    ('RAKOTO', 'Nirina', 1, '1982-09-20', 'rakoto@example.com', '1234', 1),
    ('RAHARY', 'Manitra', 2, '1995-03-10', 'rahary@example.com', '1234', 1),
    ('RAZAFY', 'Manantsoa', 1, '1988-07-25', 'razafy@example.com', '1234', 1);

-- Insertion dans la table "marque"
INSERT INTO marque (marque) VALUES 
    ('Toyota'),
    ('Honda'),
    ('Ford'),
    ('Mazda'),
    ('Nissan');

-- Insertion dans la table "categorie"
INSERT INTO categorie (categorie) VALUES 
    ('Berline'),
    ('SUV'),
    ('Hatchback'),
    ('Camionnette');

-- Insertion dans la table "carburant"
INSERT INTO carburant (carburant) VALUES 
    ('Essence'),
    ('Diesel'),
    ('Hybride'),
    ('Electrique');

-- Insertion dans la table "lieu"
INSERT INTO lieu (lieu) VALUES 
    ('Antananarivo'),
    ('Antsirabe'),
    ('Toamasina'),
    ('Fianarantsoa');

-- Insertion dans la table "model"
INSERT INTO model (marque_id, categorie_id, model) VALUES
    (1, 1, 'Camry'),
    (2, 2, 'CR-V'),
    (3, 3, 'Mazda3'),
    (4, 4, 'Frontier'),
    (5, 1, 'Altima');

INSERT INTO model (marque_id, categorie_id, model) VALUES
    (1, 2, 'Camry 2'),
    (2, 2, 'CR-V 2'),
    (3, 1, 'Mazda3 2'),
    (4, 4, 'Frontier 2'),
    (5, 4, 'Altima 2');

-- Insertion dans la table "anneesortie"
INSERT INTO anneesortie (model_id, annee) VALUES 
    (1, 2020),
    (2, 2019),
    (3, 2021),
    (4, 2022),
    (5, 2020);

-- Insertion dans la table "modelcarburant"
INSERT INTO modelcarburant (model_id, carburant_id) VALUES 
    (1, 1),
    (2, 3),
    (3, 2),
    (4, 1),
    (5, 4);

-- Insertion dans la table "voiture"
INSERT INTO voiture (model_id, matricule, kilometrage, modelcarburant_id, anneesortie_id) VALUES 
    (1, 'ABC123', 50000.5, 1, 1),
    (2, 'DEF456', 75000.2, 2, 2),
    (3, 'GHI789', 30000.8, 3, 3),
    (4, 'JKL012', 90000.1, 4, 4),
    (5, 'MNO345', 60000.3, 5, 5);

-- Insertion dans la table "annonce"
INSERT INTO annonce (voiture_id, prix_vente, statut, date_annonce, date_confirmation) VALUES 
    (1, 25000.00, 1, '2024-01-10 12:30:00', NULL),
    (2, 20000.50, 2, '2024-01-12 15:45:00', '2024-01-15 10:00:00'),
    (3, 30000.75, 1, '2024-01-15 09:15:00', NULL),
    (4, 18000.20, 1, '2024-01-18 14:20:00', NULL),
    (5, 22000.80, 2, '2024-01-20 11:00:00', '2024-01-22 08:30:00');

-- Insertion dans la table "vente"
INSERT INTO vente (annonce_id, acheteur_id, prix_achat, date_achat) VALUES 
    (1, 1, 24000.00, '2022-02-01 14:45:00'),
    (2, 2, 19500.00, '2022-02-05 09:30:00'),
    (3, 3, 29000.00, '2022-02-10 11:15:00'),
    (4, 4, 17500.00, '2022-02-15 13:20:00'),
    (5, 5, 21000.00, '2022-02-20 16:00:00');



/***** Hasinjo ***/
INSERT INTO boitevitesse (boitevitesse) VALUES
('Automatic'),
('Manual'),
('CVT'),
('Semi-Automatic');

INSERT INTO annonce (voiture_id, lieu_id, vendeur_id, prix_vente, statut, date_annonce, date_confirmation) VALUES 
    (1, 1, 1, 25000.00, 1, '2024-01-10 12:30:00', NULL),
    (2, 1, 4, 20000.50, 2, '2024-01-12 15:45:00', '2024-01-15 10:00:00'),
    (3, 3, 3, 30000.75, 1, '2024-01-15 09:15:00', NULL),
    (4, 2, 2,  18000.20, 1, '2024-01-18 14:20:00', NULL),
    (5, 2, 1, 22000.80, 2, '2024-01-20 11:00:00', '2024-01-22 08:30:00');

-- Insertion dans la table "vente"
INSERT INTO vente (annonce_id, acheteur_id, prix_achat, taux_comission, date_achat) VALUES 
    (1, 1, 24000.00, 5, '2022-02-01 14:45:00'),
    (2, 2, 19500.00, 5, '2022-02-05 09:30:00'),
    (3, 3, 29000.00, 5, '2022-02-10 11:15:00'),
    (4, 4, 17500.00, 5, '2022-02-15 13:20:00'),
    (5, 5, 21000.00, 5, '2022-02-20 16:00:00');
