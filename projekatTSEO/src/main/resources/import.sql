SET FOREIGN_KEY_CHECKS = 0


--TRUNCATE TABLE user_role;
--TRUNCATE TABLE admins;
--TRUNCATE TABLE teachers;
--TRUNCATE TABLE student;
TRUNCATE TABLE role;
TRUNCATE TABLE users;
TRUNCATE TABLE courses;
TRUNCATE TABLE documents;
TRUNCATE TABLE payments;
TRUNCATE TABLE enrollments;
TRUNCATE TABLE course_teacher;
TRUNCATE TABLE exams;
TRUNCATE TABLE exam_period;

SET FOREIGN_KEY_CHECKS = 1


INSERT INTO role (name) VALUES ('admin');
INSERT INTO role (name) VALUES ('teacher');
INSERT INTO role (name) VALUES ('student');

INSERT INTO users (username, password, name, lastname, role) VALUES ('pera', 'pera', 1);
INSERT INTO users (username, password, name, lastname, role) VALUES ('ana', 'ana', 'Ana', 'Mitic', 2);
INSERT INTO users (username, password, name, lastname, role) VALUES ('mile', 'mile', 'Mile', 'Milic', 3);

--INSERT INTO user_role (korisnik_id, uloga_id) VALUES (1, 1);
--INSERT INTO user_role (korisnik_id, uloga_id) VALUES (2, 2);
--INSERT INTO user_role (korisnik_id, uloga_id) VALUES (3, 3);

INSERT INTO courses (name, points) VALUES ('Osnove web programiranja', 6);
INSERT INTO courses (name, points) VALUES ('Engleski jezik', 4);
INSERT INTO courses (name, points) VALUES ('Matematika 2', 8);

INSERT INTO documents (document_type) VALUES ('upisnica');

			
INSERT INTO student (card_number, course_enrollment, passed_courses, left_courses, documents, payments) VALUES ('SF 33/2018', 1, 2, 3, 1, 1);			

INSERT INTO payments (student, reason_for_payment, receiver, amount, recievers_account, model, call_number, payment_date)
			VALUES (3, 'Uplata za ispitni rok', 'Fakultet Tehnickih Nauka', 1000, '123456', 97, '73884-992', '2020-01-04');
			
INSERT INTO teacher (title, teaching_courses) VALUES ('redovni profesor', 1);

INSERT INTO course_teacher (course, teachers) VALUES (1, 2);

INSERT INTO enrollments (start, finish, course, teachers, students) VALUES ('2019-10-02', '2020-01-10', 1, 1, 3);

INSERT INTO exams (exam_date, student, course, exam_period, points, kolokvijum_points, p_obaveze_bodovi) VALUES ('2020-01-25', 1, 1, 1, 30, 30, 28);

INSERT INTO exam_period (name, period_start, period_end, exams) VALUES ('Januarski 2020', '2020-01-12', '2020-01-31', 1);






