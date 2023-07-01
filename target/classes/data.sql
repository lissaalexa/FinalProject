DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS preference_student;
DROP TABLE IF EXISTS preference;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS host_family;


CREATE TABLE host_family (
  host_id INT PRIMARY KEY,
  host_first_name VARCHAR(255),
  host_last_name VARCHAR(255),
  host_address VARCHAR(255)
);

CREATE TABLE preference (
  preference_id INT PRIMARY KEY,
  preference_name VARCHAR(255)
);

CREATE TABLE student (
  student_id INT PRIMARY KEY,
  student_first_name VARCHAR(255),
  student_last_name VARCHAR(255),
  student_date_of_birth DATE,
  student_country VARCHAR(255)
);

CREATE TABLE preference_student (
  preference_id INT,
  student_id INT,
  FOREIGN KEY (preference_id) REFERENCES preference(preference_id),
  FOREIGN KEY (student_id) REFERENCES student(student_id)
);

CREATE TABLE booking (
	booking_id INT PRIMARY KEY,
	host_id INT,
	student_id INT,
	start_date DATE,
	end_date DATE,
	FOREIGN KEY (host_id) REFERENCES host_family(host_id),
	FOREIGN KEY (student_id) REFERENCES student(student_id)
);

INSERT INTO host_family (host_id, host_first_name, host_last_name, host_address)
	VALUES (1, 'John', 'Doe', '123 Main St');

INSERT INTO student (student_id, student_first_name, student_last_name, student_date_of_birth, student_country)
	VALUES (10, 'Aleksandra', 'Kowalski', '2000-01-01', 'Poland');

INSERT INTO booking (booking_id, host_id, student_id, start_date, end_date)
	VALUES (1, 1, 10, '2023-07-01', '2023-09-02');

INSERT INTO preference (preference_id, preference_name)
	VALUES (1, 'no pets');

INSERT INTO preference (preference_id, preference_name)
	VALUES (2, 'no children');
