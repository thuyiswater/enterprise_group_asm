INSERT INTO 
	TBL_EMPLOYEES (first_name, last_name, email, phone_number, password, role)
VALUES
  	('Lokesh', 'Gupta', 'howtodoinjava@gmail.com', '1234567', 'Lo12345', 'Admin');


INSERT INTO
	TBL_VEHICLES (name, brand, plate, color, seat_number)
VALUES
  	('Camry', 'Honda', '1234', 'Black', '4'),
  	('Benz', 'Honda', '1235', 'White', '7' );

INSERT INTO
	TBL_DRIVERS (driver_name, driver_phone_number, driver_license_number, driver_year_of_experience, driver_avatar, driver_password)
VALUES
  	('John', '011223344', 'E1234', '10', 'John.png', 'this-is-password');


INSERT INTO
	TBL_USERS (user_name, user_email, user_password, user_phone_number)
VALUES
    ('test','test','test', '84'),
  	('Tommy', 'tommy@gmail.com', 'tommy123', '01223344');


INSERT INTO
	TBL_PAYMENTS (payment_type, payment_amount, payment_status, payment_date)
VALUES
  	('Cash', '100', 'Paid', '2020-01-01');


INSERT INTO
	TBL_BOOKINGS (booking_date, user_id, booking_pick_up_location, booking_drop_off_location, booking_pick_up_time, booking_drop_off_time, booking_number_of_passengers ,vehicle_id, driver_id, payment_id, booking_status )
VALUES
  	('2020-01-01', 1, 'SaiGon', 'HoiAn', '2020-01-01 10:00:00', '2020-01-01 12:00:00', '10', 1, 1, 1, 'Processing');