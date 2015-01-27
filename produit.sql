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