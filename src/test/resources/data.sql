-- applicants
INSERT INTO applicant (surname, firstName) VALUES ('Wolfe', 'Nero');
INSERT INTO applicant (surname, firstName) VALUES ('Goodwin', 'Archie');
INSERT INTO applicant (surname, firstName) VALUES ('Panzer', 'Saul');
INSERT INTO applicant (surname, firstName) VALUES ('Durkin', 'Fred');

-- technologies
INSERT INTO technology (name, description) VALUES ('Java', 'programming language since 1996');
INSERT INTO technology (name, description) VALUES ('OOP', 'Object-Oriented Programming');

-- applicant-skill
INSERT INTO applicant_technology (applicant_id, technology_id, level, note)
VALUES (2, 2, 2, 'still learning');
INSERT INTO applicant_technology (applicant_id, technology_id, level, note)
VALUES (1, 1, 0, 'never tried');
INSERT INTO applicant_technology (applicant_id, technology_id, level, note)
VALUES (3, 1, 7, 'could master better soon');
