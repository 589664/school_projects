DROP SCHEMA IF EXISTS utleieselskap CASCADE;
CREATE SCHEMA utleieselskap;
SET search_path = utleieselskap;

CREATE TABLE adresse
(
	gateadresse 		VARCHAR (50) NOT NULL,
	postNR				SMALLINT NOT NULL,
	poststed 			VARCHAR (20) NOT NULL,
	CONSTRAINT pk_gateadresse PRIMARY KEY (gateadresse)
);

CREATE TABLE selskap 
(   
    selskapID           SERIAL,
	tlf				    INTEGER,
	navn 			    VARCHAR(20),
	adresse 			VARCHAR(50),

   	CONSTRAINT pk_selskapID PRIMARY KEY (selskapID),
	CONSTRAINT fk_adresse FOREIGN KEY(adresse)
    REFERENCES adresse(gateadresse)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE kontor 
(
	kontorNR 			SERIAL,
    tlf				    INTEGER,
	adresse 			VARCHAR(50),
    selskapID           SERIAL,
	
   	CONSTRAINT pk_kontorNR PRIMARY KEY (kontorNR),

    CONSTRAINT fk_selskapID FOREIGN KEY(selskapID)
    REFERENCES selskap(selskapID)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
	CONSTRAINT fk_adresse FOREIGN KEY(adresse)
    REFERENCES adresse(gateadresse)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE bil 
(   
    regnr 			    VARCHAR(7),
	modell   			VARCHAR(15),
    farge    			VARCHAR(10),
	kategori 			CHAR(1),
    kontorNR 			SERIAL,
	
   	CONSTRAINT pk_regnr PRIMARY KEY (regnr),

    CONSTRAINT fk_kontorNR FOREIGN KEY(kontorNR)
    REFERENCES kontor(kontorNR)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE kunde 
(   
    kredittkortnr       BIGINT,
    fornavn 			VARCHAR(10),
	etternavn   		VARCHAR(15),
    adresse 			VARCHAR(50),
	tlf				    INTEGER,
    kontorNR 			SERIAL,
	
   	CONSTRAINT pk_kredittkortnr PRIMARY KEY (kredittkortnr),
    CONSTRAINT fk_kontorNR FOREIGN KEY(kontorNR)
    REFERENCES kontor(kontorNR)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
	CONSTRAINT fk_adresse FOREIGN KEY(adresse)
    REFERENCES adresse(gateadresse)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE reservasjon 
(   
    reservasjonID 		SERIAL,
	datofra   		    TIMESTAMP,
    datotil 			TIMESTAMP,
	kredittkortnr		BIGINT,
    regnr 			    VARCHAR(7),
	
   	CONSTRAINT pk_reservasjonID PRIMARY KEY (reservasjonID),

    CONSTRAINT fk_kredittkortnr FOREIGN KEY(kredittkortnr)
    REFERENCES kunde(kredittkortnr),
    
    CONSTRAINT fk_regnr FOREIGN KEY(regnr)
    REFERENCES bil(regnr)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

INSERT INTO adresse
VALUES ('Nisserødvegen 8', 5055, 'Gronlokka'),
	   ('Jokernords gate 9', 5051, 'Toten'),
	   ('Torteveien 10', 5052, 'Satangatan'),
	   ('Indreradius 7', 5053, 'Satangatan2.0');

INSERT INTO selskap
VALUES (1,91019101, 'Clownutleie AS', 'Nisserødvegen 8');

INSERT INTO kontor
VALUES (1,41010202, 'Jokernords gate 9', 1),
	   (2,41010203, 'Torteveien 10', 1);

INSERT INTO bil
VALUES ('SD92123', 'Nissan', 'Green', 'B', 1);

INSERT INTO kunde
VALUES (1111222233334444, 'Gustav', 'Clarsson', 'Indreradius 7', 98899889, 1);

INSERT INTO reservasjon
VALUES (1,'2022-01-01 14:01', '2022-01-02 14:01', 1111222233334444, 'SD92123');