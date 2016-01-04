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
  codePostal CHAR(5));
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
---------------------------------------------------------------
INSERT INTO BDA_ENTREPRISE VALUES
(1, 'Air France', BDA_adresse('rue des papyrus', 'Paris', '75000'));
INSERT INTO BDA_ENTREPRISE VALUES
(2, 'Blizzard', BDA_adresse('rue des zerglings', 'Metz', '57000'));
INSERT INTO BDA_ENTREPRISE VALUES
(3, 'Nvidia', BDA_adresse('rue des oracles', 'Toulouse', '31200'));
INSERT INTO BDA_ENTREPRISE VALUES
(4, 'Carrefour', BDA_adresse('rue des ultralisk', 'Brest', '29120'));
INSERT INTO BDA_ENTREPRISE VALUES
(5, 'Alcoliques Anonymes', BDA_adresse('rue de ggboum', 'Bordeaux', '14230'));
INSERT INTO BDA_ENTREPRISE VALUES
(6, 'Darty', BDA_adresse('rue des pokémons', 'Lille', '59201'));
INSERT INTO BDA_ENTREPRISE VALUES
(7, 'King Jouet', BDA_adresse('rue des pyramides', 'Epinal', '88210'));
INSERT INTO BDA_ENTREPRISE VALUES
(8, 'Babou', BDA_adresse('rue des nénuphars', 'Marseille', '13000'));
INSERT INTO BDA_ENTREPRISE VALUES
(9, 'La Redoute', BDA_adresse('rue des éléphants', 'Paris', '75520'));
INSERT INTO BDA_ENTREPRISE VALUES
(10, 'Peugeot', BDA_adresse('rue des abeilles', 'Pau', '23100'));
---------------------------------------------------------------
INSERT INTO BDA_STAGE VALUES
(1, 1, 1, TO_DATE('08/04/1965', 'dd/mm/yyyy'), TO_DATE('30/06/1965', 'dd/mm/yyyy'), 
BDA_adresse('rue des anglais', 'Orford', '1000'));
INSERT INTO BDA_STAGE VALUES
(2, 3, 7, TO_DATE('01/04/2010', 'dd/mm/yyyy'), TO_DATE('01/09/2010', 'dd/mm/yyyy'), 
BDA_adresse('rue des francais', 'Grenoble', '39120'));
INSERT INTO BDA_STAGE VALUES
(3, 4, 9,  TO_DATE('20/04/2013', 'dd/mm/yyyy'),  TO_DATE('10/09/2013', 'dd/mm/yyyy'), 
BDA_adresse('rue des germains', 'Lille', '59632'));
INSERT INTO BDA_STAGE VALUES
(4, 6, 2, TO_DATE('12/12/2013', 'dd/mm/yyyy'), TO_DATE('30/06/2015', 'dd/mm/yyyy'), 
BDA_adresse('rue des fromagers', 'Lorient', '35120'));
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

  

  