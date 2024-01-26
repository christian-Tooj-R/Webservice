INSERT INTO marque (nom) VALUES
('Toyota'),
('Honda'),
('Ford'),
('BMW');


INSERT INTO categorie (nom) VALUES
('Sedan'),
('SUV'),
('Hatchback'),
('Truck');



INSERT INTO utilisateur (nom, datenaissance, email, mdp, typeutilisateur) VALUES
('Hendry', '2004-09-09', 'hendry@gmail.com', '123',2),
('Christian', '2002-11-09', 'christooj@gmail.com', '456',2),
('Grace', '2006-05-20', 'grace@gmail.com', '789', 1);


 create table token(
    id serial,
    token varchar,
    cle varchar,
    datecreation date,
    dateexpiration date
);