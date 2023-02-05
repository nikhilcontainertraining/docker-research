create database card_repository;

use card_repository;

CREATE TABLE card (
    number VARCHAR(500) PRIMARY KEY,
    type VARCHAR(500) NOT NULL,
    expiration VARCHAR(5000) NOT NULL,
    owner VARCHAR(5000) NOT NULL
);