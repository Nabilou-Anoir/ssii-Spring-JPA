-- Initialisation des tables
-- Ce fichier ne peut pas être vide
INSERT INTO personne (matricule, nom, prenom, poste) VALUES
    (1, 'Gral', 'Oxana', 'Directeur'),
    (2, 'Kadi', 'Gehnima', 'Product Owner'),
    (3, 'Fauci', 'Anthonio', 'Développeur JAVA'),
    (4, 'Tatie', 'Thomas', 'Developpeur Python');

-- Mise à jour des relations hiérarchiques
UPDATE personne SET superieur_matricule = 1 WHERE matricule = 2;
UPDATE personne SET superieur_matricule = 2 WHERE matricule IN (3, 4);

-- Insertion de projet
INSERT INTO projet (code, nom, date_debut, date_fin) VALUES
(1, 'Projet A', '2023-01-28', '2024-12-31'),
(2, 'Projet B', '2024-12-01', NULL),
(3, 'Projet C', '2024-01-01', '2024-09-30');

-- Insertion des participations initiales
INSERT INTO participation (personne_matricule, projet_code, role, pourcentage) VALUES
(2, 1, 'Product Owner', 50),
(3, 1, 'Développeur JAVA', 70),
(4, 2, 'Developpeur Python', 60);
