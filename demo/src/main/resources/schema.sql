CREATE TABLE IF NOT EXISTS usuari(
    id int NOT NULL AUTO_INCREMENT,
    nom varchar(255) NOT NULL,
    cognom varchar(255) NOT NULL,
    tipus enum('ADMIN', 'ALUMNE', 'EMPRESA') NOT NULL
);
