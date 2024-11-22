CREATE DATABASE rental_machines;
use rental_machines;

CREATE TABLE customers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(100)
);

CREATE TABLE rental_machine(
	id INT PRIMARY KEY AUTO_INCREMENT,
    date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rentals(
	id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    customer_id INT,
    rental_machine_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE,
    FOREIGN KEY (rental_machine_id) REFERENCES rental_machine(id) ON DELETE CASCADE
);

CREATE TABLE machines(
	id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(70) NOT NULL,
    serie INT UNIQUE NOT NULL,
    state ENUM('AVAILABLE', 'RENTED') NOT NULL,
    rental_machine_id INT,
    FOREIGN KEY (rental_machine_id) REFERENCES rental_machine(id) ON DELETE CASCADE
);
