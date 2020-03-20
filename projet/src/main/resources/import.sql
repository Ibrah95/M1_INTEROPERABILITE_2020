INSERT INTO ouverture_bu (bibliotheque, ouverture) VALUES('BU Trefilerie', ' Lundi au vendredi 8h-20h/Samedi 9h-18h30');
INSERT INTO ouverture_bu (bibliotheque, ouverture) VALUES ('BU Sciences', 'Lundi au vendredi 8h-18h30 / Samedi 9h-12h');
INSERT INTO ouverture_bu (bibliotheque, ouverture) VALUES ('BU Sante', 'Lundi au vendredi 8h-20h');
INSERT INTO ouverture_bu (bibliotheque, ouverture) VALUES ('BU Roanne', ' Lundi 8h45-18h / Mardi au vendredi 8h45-18h30');
INSERT INTO ouverture_bu (bibliotheque, ouverture) VALUES ('BU Manufacture', 'Jeudi 9h-15h30 en presence d’une bibliothecaire. Acces badge pendant les heures d’ouverture de l’Eco'); 



INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement sportive','BU Roanne ','jeudi 06 decembre 17h-20h'); 
INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement culturelle', 'BU Sciences','Lundi au vendredi 8h-17h'); 
INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement de santé', 'BU Sante','vendredi 12 janvier 8h-14h'); 
INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement pour les nouveaux etudiants','BU Manufacture', 'Lundi 01 septembre 8h-14h'); 
INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement pour les nouveaux etudiants etrangers','BU Sante', 'Lundi 06 septembre 8h-11h'); 
INSERT INTO evenement (name_event, bibliotheque,date_event) VALUES ('evenement sur les linteret de la lecture  ','BU Manufacture', 'Lundi 01 septembre 8h-14h'); 


INSERT INTO Budget (bibliotheque, budget_par_an) VALUES('BU Trefilerie', ' 850000 euros');
INSERT INTO Budget (bibliotheque, budget_par_an) VALUES('BU  Roanne', '350000 euros');
INSERT INTO Budget (bibliotheque, budget_par_an) VALUES('BU de santé', '160000 euros');
INSERT INTO Budget (bibliotheque, budget_par_an) VALUES('BU Manufacture', '200000 euros' );
INSERT INTO Budget (bibliotheque, budget_par_an) VALUES ('BU Sciences', '500000 euros');
