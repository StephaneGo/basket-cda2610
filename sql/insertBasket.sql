-- Équipes (nom unique, 30 caractères max)
INSERT INTO EQUIPES (nom) VALUES
                              ('Les Aigles'),
                              ('Les Requins'),
                              ('Les Tigres'),
                              ('Les Loups'),
                              ('Les Faucons'),
                              ('Les Dragons');

-- Joueurs (noEquipe de 1 à 6 selon l'ordre d'insertion ci-dessus)
INSERT INTO JOUEURS (prenom, nom, email, id_equipe) VALUES
-- Les Aigles (1)
('Lucas',    'Martin',   'lucas.martin@mail.fr',    1),
('Emma',     'Bernard',  'emma.bernard@mail.fr',    1),
('Hugo',     'Dubois',   'hugo.dubois@mail.fr',     1),
('Chloé',    'Thomas',   NULL,                      1),

-- Les Requins (2)
('Louis',    'Robert',   'louis.robert@mail.fr',    2),
('Léa',      'Richard',  'lea.richard@mail.fr',     2),
('Nathan',   'Petit',    'nathan.petit@mail.fr',    2),
('Manon',    'Durand',   'manon.durand@mail.fr',    2),

-- Les Tigres (3)
('Gabriel',  'Leroy',    'gabriel.leroy@mail.fr',   3),
('Camille',  'Moreau',   'camille.moreau@mail.fr',  3),
('Jules',    'Simon',    NULL,                      3),
('Inès',     'Laurent',  'ines.laurent@mail.fr',    3),

-- Les Loups (4)
('Arthur',   'Lefebvre', 'arthur.lefebvre@mail.fr', 4),
('Sarah',    'Michel',   'sarah.michel@mail.fr',    4),
('Raphaël',  'Garcia',   'raphael.garcia@mail.fr',  4),
('Jade',     'David',    'jade.david@mail.fr',      4),

-- Les Faucons (5)
('Adam',     'Bertrand', 'adam.bertrand@mail.fr',   5),
('Louise',   'Roux',     'louise.roux@mail.fr',     5),
('Maël',     'Vincent',  NULL,                      5),
('Alice',    'Fournier', 'alice.fournier@mail.fr',  5),

-- Les Dragons (6)
('Ethan',    'Morel',    'ethan.morel@mail.fr',     6),
('Zoé',      'Girard',   'zoe.girard@mail.fr',      6),
('Tom',      'Andre',    'tom.andre@mail.fr',       6),
('Lina',     'Mercier',  'lina.mercier@mail.fr',    6);