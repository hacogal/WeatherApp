CREATE DATABASE weatherDB;

USE weatherDB;

CREATE TABLE toronto_weather_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    temperature DOUBLE NOT NULL,
    feelslike DOUBLE NOT NULL,
    humidity DOUBLE NOT NULL,
    windspeed DOUBLE NOT NULL,
    pressure DOUBLE NOT NULL
);

select * from toronto_weather_data;

insert into toronto_weather_data
(date,temperature,feelslike,humidity,windspeed,pressure) values
('2024-06-19', 23.5, 23.7, 79.2, 13, 1022.6),
('2024-06-20', 20.6, 22.6, 82.5, 9.4, 1023.6),
('2024-06-21', 20.8, 20.8, 81.7, 14.8, 1022),
('2024-06-22', 18.7, 18.6, 91.9, 18.7, 1016),
('2024-06-23', 20.6, 19, 88.2, 30.6, 1002.9),
('2024-06-24', 18.8, 17.8, 80.8, 23.4, 1005.4),
('2024-06-25', 19.6, 19.6, 76.7, 21.6, 1008.3);




