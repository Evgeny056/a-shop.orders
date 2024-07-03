CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       last_name VARCHAR(80) NOT NULL,
                       first_name VARCHAR(80) NOT NULL,
                       phone_number VARCHAR(20),
                       email VARCHAR(80) NOT NULL
);
