CREATE TABLE comptables (
                            comptable_id INT PRIMARY KEY AUTO_INCREMENT,
                            nom VARCHAR(255) NOT NULL,
                            prenom VARCHAR(255) NOT NULL,
                            email VARCHAR(255),
                            telephone VARCHAR(20)
);

CREATE TABLE clients (
                         client_id INT PRIMARY KEY AUTO_INCREMENT,
                         nom_entreprise VARCHAR(255) NOT NULL,
                         siret VARCHAR(14) NOT NULL UNIQUE,
                         adresse TEXT,
                         comptable_id INT,
                         FOREIGN KEY (comptable_id) REFERENCES comptables(comptable_id)
);

CREATE TABLE taxe_apprentissage (
                                   taxe_id INT PRIMARY KEY AUTO_INCREMENT,
                                   client_id INT,
                                   masse_salariale INT NOT NULL,
                                   montant_taxe INT NOT NULL,
                                   date_calcul DATE NOT NULL,
                                   FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE paiements (
                           paiement_id INT PRIMARY KEY AUTO_INCREMENT,
                           taxe_id INT,
                           montant_paye INT NOT NULL,
                           date_paiement DATE NOT NULL,
                           FOREIGN KEY (taxe_id) REFERENCES taxe_apprentissage(taxe_id)
);
