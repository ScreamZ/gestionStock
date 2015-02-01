/* BDD relationnelle MYSQL */
CREATE TABLE Catalogue
(
  id  INTEGER AUTO_INCREMENT NOT NULL,
  nom VARCHAR(255)           NOT NULL,
  CONSTRAINT pk_catalogue PRIMARY KEY (id),
  CONSTRAINT unique_catalogue_nom UNIQUE (nom)
);
CREATE TABLE Produit
(
  id               INTEGER      NOT NULL,
  nom              VARCHAR(255) NOT NULL,
  quantite         INT          NOT NULL,
  prix_unitaire_ht DOUBLE       NOT NULL,
  catalogue_id     INTEGER      NOT NULL,
  CONSTRAINT pk_produit PRIMARY KEY (id),
  CONSTRAINT unique_nom UNIQUE (nom, catalogue_id),
  CONSTRAINT fk_produit_catalogue FOREIGN KEY (catalogue_id) REFERENCES Catalogue (id)
    ON DELETE CASCADE
);