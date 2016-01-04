-- ############################################################
-- CREATION BASE DE DONNES
-- ############################################################
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
-- ############################################################
-- INSERTION DES VALUES
-- ############################################################
INSERT INTO BDA_ETUDIANT VALUES
(1, 'Albert', 'Einstein', 1, TO_DATE('08/01/1965', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(2, 'Wilhelm', 'Röntgen', 0, NULL);
INSERT INTO BDA_ETUDIANT VALUES
(3, 'Hendrik', 'Lorentz', 1, TO_DATE('04/01/2010', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(4, 'Gabriel', 'Lippmann', 1, TO_DATE('10/03/2013', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(5, 'François', 'Hollande', 0, NULL);
INSERT INTO BDA_ETUDIANT VALUES
(6, 'Marc', 'Zukerberg', 1, TO_DATE('12/12/2013', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(7, 'Alain', 'Delon', 0, NULL);
INSERT INTO BDA_ETUDIANT VALUES
(8, 'Alain', 'Bernard', 0, NULL);
INSERT INTO BDA_ETUDIANT VALUES
(9, 'Clovis', 'France', 1, TO_DATE('08/01/1206', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(10, 'Céline', 'Dion', 1, TO_DATE('15/04/1962', 'dd/mm/yyyy'));

-- ############################################################
-- FONCTIONS PL/SQL
-- ############################################################
CREATE OR REPLACE FUNCTION nbEtudiantsAvecStage(anneeStage IN INTEGER) RETURN INTEGER IS
  nbStageCetteAnnée INTEGER;
  BEGIN
      SELECT COUNT(*) INTO nbStageCetteAnnée
      FROM BDA_STAGE
      WHERE TO_CHAR(dateDebut, 'YYYY') = anneeStage;
        return nbStageCetteAnnée;
  END;
    
CREATE OR REPLACE FUNCTION nbEtudiantsSansStage (anneeStage in INTEGER) RETURN INTEGER IS
  nbStageCetteAnnée INTEGER;

  BEGIN
      SELECT COUNT(*) INTO nbStageCetteAnnée
      FROM BDA_STAGE
      WHERE TO_CHAR(dateDebut, 'YYYY') = anneeStage
        AND  dateDebut IS NULL;
        return nbStageCetteAnnée;
  END;
  /
    
CREATE OR REPLACE FUNCTION nbEtudiantsSansStageAvecDate (anneeStage in INTEGER) RETURN INTEGER IS
  nbStageCetteAnnée INTEGER;

  BEGIN
      SELECT COUNT(*) INTO nbStageCetteAnnée
      FROM BDA_STAGE
      WHERE TO_CHAR(dateDebut, 'YYYY') = anneeStage;

        return nbStageCetteAnnée;
  END;
  /

  

  