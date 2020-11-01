INSERT INTO defaultdb.users (id, first_name, last_name, age, address, job_status, mail, photo) VALUES (1, 'Elena', 'Ortega', 22, '46 rue mouchez', 'Etudiante', 'elena.ortega@epfedu.fr', 'elena.ortega.jpg');
INSERT INTO defaultdb.languages(id, user_id, name, level) VALUES (1,1,'Espagnol','Bilingue');
INSERT INTO defaultdb.educations(id, user_id, title, place, starting_date, final_date, summary) VALUES (1,1,'Stage 4A','NZ','2019-09-09','2019-12-20','Stage élève ingénieur de 4A');
INSERT INTO defaultdb.links(id, user_id, title, link, is_checked) VALUES (1,1, 'Facebook', null, false);
INSERT INTO defaultdb.links(id, user_id, title, link, is_checked) VALUES (2,1, 'Instagram', null, false);
INSERT INTO defaultdb.links(id, user_id, title, link, is_checked) VALUES (3,1, 'LinkedIn', null, false);
INSERT INTO defaultdb.links(id, user_id, title, link, is_checked) VALUES (4,1, 'GitHub', null, false);
INSERT INTO defaultdb.links(id, user_id, title, link, is_checked) VALUES (5,1, 'Twitter', null, false);