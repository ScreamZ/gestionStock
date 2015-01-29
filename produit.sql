CREATE TABLE Produit
(
  id               NUMBER         NOT NULL,
  nom              VARCHAR2(4000) NOT NULL,
  quantité         INT            NOT NULL,
  prix_unitaire_ht NUMBER         NOT NULL
);
ALTER TABLE Produit
ADD CONSTRAINT pk_produit PRIMARY KEY (id);
ALTER TABLE Produit
ADD CONSTRAINT unique_nom UNIQUE (nom);
CREATE SEQUENCE produit_seq;
CREATE OR REPLACE PROCEDURE nouveauProduit(p_nomProduit     IN PRODUIT.NOM%TYPE, p_quantite IN PRODUIT.QUANTITE%TYPE,
                                           p_prixUnitaireHT IN PRODUIT.PRIX_UNITAIRE_HT%TYPE)
IS
  BEGIN
    INSERT INTO Produit VALUES (produit_seq.nextval, p_nomProduit, p_quantite, p_prixUnitaireHT);
  END;