create database vehicule;
\c vehicule;

create table marque(
    id serial primary key,
    nom varchar(50)
);
INSERT INTO marque (nom) VALUES
('Toyota'),
('Honda'),
('Ford'),
('BMW');


create table categorie(
    id serial primary key,
    nom varchar(50)
);
INSERT INTO categorie (nom) VALUES
('Sedan'),
('SUV'),
('Hatchback'),
('Truck');


create table utilisateur(
    id serial primary key,
    nom varchar(50),
    datenaissance date,
    email varchar(50),
    mdp varchar(50),
    typeutilisateur int
);

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


create table peripherique(
    id serial,
    iduser int references utilisateur(id),
    token varchar
);
create table notifuser(
    id serial,
    iduser int references utilisateur(id),
    message text
);