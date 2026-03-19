-- V1 Create table event
CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    start_date_time TIMESTAMP NOT NULL,
    end_date_time TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INT NOT NULL,
    organizer VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);