DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS preference_student;
DROP TABLE IF EXISTS preference;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS host_family;


CREATE TABLE host_family (
  host_id INT AUTO_INCREMENT,
  host_first_name VARCHAR(255),
  host_last_name VARCHAR(255),
  host_address VARCHAR(255),
  PRIMARY key (host_id)
);

CREATE TABLE preference (
  preference_id INT AUTO_INCREMENT,
  preference_name VARCHAR(255),
  primary key (preference_id)
);

CREATE TABLE student (
  student_id INT AUTO_INCREMENT,
  student_first_name VARCHAR(255),
  student_last_name VARCHAR(255),
  student_date_of_birth DATE,
  student_country VARCHAR(255),
  primary key (student_id)
);

CREATE TABLE preference_student (
  preference_id INT,
  student_id INT,
  FOREIGN KEY (preference_id) REFERENCES preference(preference_id),
  FOREIGN KEY (student_id) REFERENCES student(student_id),
  unique key (preference_id, student_id)
);

CREATE TABLE booking (
	booking_id INT AUTO_INCREMENT,
	host_id INT,
	student_id INT,
	start_date DATE,
	end_date DATE,
	FOREIGN KEY (host_id) REFERENCES host_family(host_id),
	FOREIGN KEY (student_id) REFERENCES student(student_id),
	primary key (booking_id)
);

INSERT INTO host_family (host_first_name, host_last_name, host_address)
	VALUES ('John', 'Doe', '123 Main St');

INSERT INTO student (student_first_name, student_last_name, student_date_of_birth, student_country)
	VALUES ('Aleksandra', 'Kowalski', '2000-01-01', 'Poland');

INSERT INTO booking (host_id, student_id, start_date, end_date)
	VALUES (1, 1, '2023-07-01', '2023-09-02');

INSERT INTO preference (preference_name)
	VALUES ('no pets');

INSERT INTO preference (preference_name)
	VALUES ('no children');
