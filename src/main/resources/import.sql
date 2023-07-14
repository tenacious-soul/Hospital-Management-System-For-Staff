CREATE TABLE IF NOT EXISTS patient(patient_id bigint AUTO_INCREMENT,age integer,patient_status integer,room_number integer,admission_date timestamp,mobile_number bigint, doctor_name character varying,patient_name character varying, gender character varying, primary key(patient_id));

INSERT INTO patient(age, patient_status, room_number, admission_date, mobile_number, doctor_name, patient_name, gender) VALUES (68, 1, 001, '2023-01-05', 9999999990, 'Dr. Mukesh Agrawal', 'Mary', 'Female');

INSERT INTO patient(age, patient_status, room_number, admission_date, mobile_number, doctor_name, patient_name, gender) VALUES (98, 1, 002, '2023-03-27', 9999999991, 'Dr. Ashok Agrawal', 'John', 'Male');