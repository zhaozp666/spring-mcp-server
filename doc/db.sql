
-- create database
CREATE DATABASE IF NOT EXISTS ai CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create table
CREATE TABLE IF NOT EXISTS ai.weather (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    weather VARCHAR(20) NOT NULL,
    temperature DECIMAL(5,2) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--insert data
INSERT INTO ai.weather (city, weather, temperature)
VALUES ('北京', '晴', 25.5),
       ('上海', '阴', 22.8),
       ('广州', '多云', 24.2),
       ('深圳', '雨', 21.0);
