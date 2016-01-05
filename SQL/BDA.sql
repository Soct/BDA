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
  promo DATE NOT NULL,
  dateObtentionStage DATE);
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
(1, 'Albert', 'Einstein', TO_DATE('1965', 'yyyy'), TO_DATE('08/01/1965', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(2, 'Wilhelm', 'Röntgen', TO_DATE('2016', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(3, 'Hendrik', 'Lorentz', TO_DATE('2010', 'yyyy'), TO_DATE('04/01/2010', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(4, 'Gabriel', 'Lippmann', TO_DATE('2013', 'yyyy'), TO_DATE('10/03/2013', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(5, 'François', 'Hollande',TO_DATE('2015', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(6, 'Marc', 'Zukerberg', TO_DATE('2013', 'yyyy'), TO_DATE('12/12/2013', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(7, 'Alain', 'Delon', TO_DATE('2016', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(8, 'Alain', 'Bernard',  TO_DATE('2016', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(9, 'Clovis', 'France', TO_DATE('1206', 'yyyy'), TO_DATE('08/01/1206', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(10, 'Céline', 'Dion', TO_DATE('1962', 'yyyy'), TO_DATE('15/04/1962', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(11, 'Michel', 'Galabru', TO_DATE('2016', 'yyyy'), TO_DATE('05/01/2016', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(12, 'Marcel', 'Pagnol', TO_DATE('2016', 'yyyy'), TO_DATE('08/02/2016', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(13, 'Francis', 'Cabrel', TO_DATE('2016', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(14, 'Léonardo', 'Di Caprio', TO_DATE('2016', 'yyyy'), NULL);
INSERT INTO BDA_ETUDIANT VALUES
(15, 'Dark', 'Vador', TO_DATE('5986', 'yyyy'), TO_DATE('15/06/5986', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(16, 'Napoléon', 'Bonaparte', TO_DATE('2016', 'yyyy'), TO_DATE('01/04/2016', 'dd/mm/yyyy'));
INSERT INTO BDA_ETUDIANT VALUES
(17, 'Gilbert', 'Montagné', TO_DATE('2016', 'yyyy'), TO_DATE('01/02/2016', 'dd/mm/yyyy'));
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
INSERT INTO BDA_STAGE VALUES
(5, 9, 7, TO_DATE('08/01/1206', 'dd/mm/yyyy'), TO_DATE('08/07/1206', 'dd/mm/yyyy'), 
BDA_adresse('rue du moyen-age', 'Lutèce', '78503'));
INSERT INTO BDA_STAGE VALUES
(6, 10, 1, TO_DATE('19/04/1962', 'dd/mm/yyyy'), TO_DATE('14/06/1962', 'dd/mm/yyyy'), 
BDA_adresse('rue de on connait pas', 'Pékin', '23520'));
INSERT INTO BDA_STAGE VALUES
(7, 11, 3, TO_DATE('15/08/2016', 'dd/mm/yyyy'), TO_DATE('10/10/2016', 'dd/mm/yyyy'), 
BDA_adresse('rue des pommes de terres', 'Ploumoguer', '23200'));
INSERT INTO BDA_STAGE VALUES
(8, 12, 7, TO_DATE('15/02/2016', 'dd/mm/yyyy'), TO_DATE('08/06/2016', 'dd/mm/yyyy'), 
BDA_adresse('rue des fénéants', 'Brest', '29200'));
INSERT INTO BDA_STAGE VALUES
(9, 15, 10, TO_DATE('30/06/5986', 'dd/mm/yyyy'), TO_DATE('30/06/6000', 'dd/mm/yyyy'), 
BDA_adresse('rue des étoiles noires', 'Galaxie Nord', '99000'));
INSERT INTO BDA_STAGE VALUES
(10, 16, 8, TO_DATE('15/04/2016', 'dd/mm/yyyy'), TO_DATE('15/06/2016', 'dd/mm/yyyy'), 
BDA_adresse('rue de trafalgar', 'Marseille', '13000'));
INSERT INTO BDA_STAGE VALUES
(11, 17, 2, TO_DATE('01/03/2016', 'dd/mm/yyyy'), TO_DATE('15/05/2016', 'dd/mm/yyyy'), 
BDA_adresse('rue de bonjour', 'Marseille', '12000'));
-- ############################################################
-- FONCTIONS PL/SQL
-- ############################################################
-- QUESTION 1
CREATE OR REPLACE FUNCTION nbEtudiantsAvecStage  --creation de la fonction nbEtudiantsAvecStage
RETURN INTEGER IS nbStageCetteAnnee INTEGER; --retourne un entier de nom nbStageCetteAnnee
  BEGIN
    SELECT COUNT(*) INTO nbStageCetteAnnee --compte le nombre d'étudiant ayant un stage et le met dans la variable nbStageCetteAnnee
    FROM BDA_ETUDIANT E --on utilise la table etudiant
    WHERE TO_CHAR(E.DATEOBTENTIONSTAGE, 'YYYY')=TO_CHAR(sysdate, 'YYYY'); --la date d'obtention du stage est égal a la date de l'année
    RETURN nbStageCetteAnnee; --retourne le nombre d'étudiant avec un stage cette année
  END;
-- QUESTION 2
CREATE OR REPLACE FUNCTION nbEtudiantsSansStage  --creation de la fonction nbEtudiantsSansStage
RETURN INTEGER IS nbNonStageCetteAnnee INTEGER;--retourne un entier de nom nbNonStageCetteAnnee
  BEGIN
    SELECT COUNT(*) INTO nbNonStageCetteAnnee --compte le nombre d'étudiant n'ayant pas un stage et le met dans la variable nbStageCetteAnnee
    FROM BDA_ETUDIANT E --on utilise la table etudiant
    WHERE E.DATEOBTENTIONSTAGE IS NULL --la date d'obtention du stage doit etre null
    AND TO_CHAR(E.PROMO, 'YYYY')=TO_CHAR(sysdate, 'YYYY'); --l'année de la promo est égal à la date de l'année
    RETURN nbNonStageCetteAnnee; --retourne le nombre d'étudiant sans stage cette année
  END;
-- QUESTION 3
CREATE OR REPLACE FUNCTION nbEtudiantsSansStageAvecDate(anneeStage IN DATE) --creation de la fonction nbEtudiantsSansStageAvecDate avec comme parametre une date que l'utilisateur saissira
RETURN INTEGER IS nbStageCetteAnnee INTEGER; --retourne un entier de nom nbStageCetteAnnee
  BEGIN
    SELECT COUNT(*) INTO nbStageCetteAnnee --compte le nombre d'étudiant ayant un stage et le met dans la variable nbStage cette année
    FROM BDA_STAGE S, BDA_ETUDIANT E --on utilise la table etudiant et stage
    WHERE S.ETUDIANT=E.ID_ETUDIANT --l'ID de l'étudiant de la table etudiant est égal à l'étudiant du stage
    AND E.DATEOBTENTIONSTAGE < anneeStage -- limite le nombre de stage comptabilisé à la date donnée par l'utilisateur
    AND TO_CHAR(E.PROMO, 'YYYY')=TO_CHAR(anneeStage, 'YYYY'); --l'année de la promo est égal à la date à anneeStage
    RETURN nbStageCetteAnnee; --retourne le nombre d'étudiant avec un stage cette année
  END;
-- QUESTION 4
CREATE OR REPLACE FUNCTION nbStageParEntrepriseNAnnees(nbAnnee IN INTEGER) --creation de la fonction nbEtudiantsParEntrepriseNAnnees avec comme parametre les n dernieres année pris en compte l'utilisateur saissira
RETURN VARCHAR2 IS table_return BDA_STAGE.BDA_STAGE%TYPE; -- retourne un string de nom table_return
  BEGIN
    SELECT * INTO table_return 
    FROM BDA_ENTREPRISE ET, BDA_STAGE S --on utilise la table entreprise et stage
    WHERE ET.ID_ENTREPRISE=S.ENTREPRISE --l'id de l'entreprise est égal à celui de l'entreprise du stage
    AND TO_CHAR(sysdate, 'YYYY')-TO_CHAR(S.DATEDEBUT, 'YYYY')<nbAnnee;  
    RETURN table_return;
  END;

  

  