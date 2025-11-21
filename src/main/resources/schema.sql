DROP TABLE IF EXISTS "flights";

CREATE TABLE "flights" (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         flight_number VARCHAR(255) NOT NULL,
                         airline_name VARCHAR(255) NOT NULL,
                         origin_city VARCHAR(255) NOT NULL,
                         destination_city VARCHAR(255) NOT NULL,
                         schedule_date DATE NOT NULL,
                         departure_time TIME NOT NULL,
                         arrival_time TIME NOT NULL,
                         base_fare DOUBLE NOT NULL,
                         total_seats INT NOT NULL,
                         available_seats INT NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP
);
