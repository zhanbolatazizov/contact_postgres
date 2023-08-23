CREATE TABLE contacts (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          first_number VARCHAR(20) NOT NULL,
                          second_number VARCHAR(20),
                          created_date TIMESTAMP
);

INSERT INTO contacts (name, first_number, second_number, created_date)
VALUES ('Jon Snow', '87057894542', '870784500980', NOW());

INSERT INTO contacts (name, first_number, second_number, created_date)
VALUES ('Micheal Jordan', '87764421464', '+77774356845', NOW());

INSERT INTO contacts (name, first_number, second_number, created_date)
VALUES ('Leonel Messi', '+77756328678', '87758406598', NOW());