/* BDD relationnelle  ORACLE */
CREATE TABLE Catalogue
(
  id  NUMBER         NOT NULL,
  nom VARCHAR2(4000) NOT NULL,
  CONSTRAINT pk_catalogue PRIMARY KEY (id),
  CONSTRAINT unique_catalogue_nom UNIQUE (nom)
);
CREATE SEQUENCE catalogue_seq;
CREATE OR REPLACE PROCEDURE nouveauCatalogue(p_nomCatalogue IN CATALOGUE.NOM%TYPE)
IS
  BEGIN
    INSERT INTO Catalogue VALUES (catalogue_seq.nextval, p_nomCatalogue);
  END;

CREATE TABLE Produit
(
  id               NUMBER         NOT NULL,
  nom              VARCHAR2(4000) NOT NULL,
  quantite         INT            NOT NULL,
  prix_unitaire_ht NUMBER         NOT NULL,
  catalogue_id     NUMBER         NOT NULL,
  CONSTRAINT pk_produit PRIMARY KEY (id),
  CONSTRAINT unique_nom UNIQUE (nom,catalogue_id),
  CONSTRAINT fk_produit_catalogue FOREIGN KEY (catalogue_id) REFERENCES Catalogue (id) ON DELETE CASCADE
);
CREATE SEQUENCE produit_seq;
CREATE OR REPLACE PROCEDURE nouveauProduit(p_nomProduit     IN PRODUIT.NOM%TYPE,
                                           p_quantite       IN PRODUIT.QUANTITE%TYPE,
                                           p_prixUnitaireHT IN PRODUIT.PRIX_UNITAIRE_HT%TYPE,
                                           p_catalogue      IN CATALOGUE.NOM%TYPE)
IS
DECLARE v_id NUMBER;
  BEGIN
    SELECT ID
    INTO v_id
    FROM Catalogue
    WHERE nom = p_catalogue;
    INSERT INTO Produit VALUES (produit_seq.nextval, p_nomProduit, p_quantite, p_prixUnitaireHT, v_id);
  END;


/* BDD OBJET A VERIFIER */
CREATE OR REPLACE TYPE produit_type AS OBJECT
(
  nomproduit       VARCHAR2(4000),
  quantite         INT,
  prix_unitaire_ht NUMBER
);
CREATE TYPE produit_nt_type AS TABLE OF produit_type;
CREATE OR REPLACE TYPE catalogue_type AS OBJECT
(
  nomcatalogue VARCHAR2(4000),
  produits     produit_nt_type
);
CREATE TABLE ProduitObject OF produit_type
(
  CONSTRAINT pk_produitobject PRIMARY KEY (nomproduit)
);
CREATE TABLE CatalogueType OF catalogue_type
(
  CONSTRAINT pk_cataloguetype PRIMARY KEY (nomcatalogue)
)
