-- DROP
DROP TABLE BDA_stage;
DROP TABLE BDA_entreprise;
DROP TABLE BDA_etudiant;
DROP TYPE BDA_adresse;
-- CREATION DE L'OBJET ADRESSE
CREATE TYPE BDA_adresse AS OBJECT(
  rue VARCHAR2(50),
  ville VARCHAR2(50),
  codePostal CHAR(5),
  departement CHAR(2));
-- CREATION DE L'OBJET ETUDIANT
CREATE TABLE BDA_etudiant(
  id_etudiant INTEGER NOT NULL PRIMARY KEY, 
  prenom VARCHAR2(50) NOT NULL, 
  nom VARCHAR2(50) NOT NULL, 
  stageGot INTEGER NOT NULL, 
  dateObsgetentionStage DATE);
-- CREATION DE L'OBJET ENTREPRISE
CREATE TABLE BDA_entreprise(
  id_entreprise INTEGER NOT NULL PRIMARY KEY, 
  nom VARCHAR2(50) NOT NULL, 
  adresse BDA_adresse NOT NULL); 
-- CREATION DE L'OBJET STAGE
CREATE TABLE BDA_stage(
  id_stage INTEGER NOT NULL PRIMARY KEY, 
  etudiant INTEGER NOT NULL REFERENCES BDA_etudiant (id_etudiant),
  entreprise INTEGER NOT NULL REFERENCES BDA_entreprise(id_entreprise),
  dateDebut DATE NOT NULL, 
  dateFin DATE NOT NULL,
  adresse BDA_adresse NOT NULL);

  

  