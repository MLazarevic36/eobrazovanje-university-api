INSERT INTO users VALUES (1, FALSE, '$2y$12$Bxm7f8lGtwzhv6R3gqJ1UuZI8oBl5rcgMB0nEue/EA2Y6XjL/ZeTO', 'STUDENT', 'fica');
INSERT INTO users VALUES (2, FALSE, '$2y$12$Znhml4xyE5OdYfa9poA66uhO2zk80D73aJ3P39jKATIGt09HX/hKW', 'STUDENT', 'gabi');
INSERT INTO users VALUES (3, FALSE, '$2y$12$3CfNcR9fOXJPAqEEGQ.EleNrjskPg/8PP.tlHocPHHfEF2Gni5Vm6', 'STUDENT', 'bosko');
INSERT INTO users VALUES (4, FALSE, '$2y$12$k.8ZNFHlnn2prT6g0m3afO3HW8mkWH0XDRNi/S5X5txNGzkaj3.AC', 'STUDENT', 'zoki');
INSERT INTO users VALUES (5, FALSE, '$2y$12$b.YjNM1vMFND7y6qxHnpSOUpBY4bvZ5UBPpR8alFRxxXgrYOL39bq', 'STUDENT', 'kole');
INSERT INTO users VALUES (6, FALSE, '$2y$12$Cm1HAA/bwdtrlKisjn2uaO2Vv3.p3n8k6B/mMrbzK2PMV7a3bYzzW', 'STUDENT', 'mile');
INSERT INTO users VALUES (7, FALSE, '$2y$12$XT4faFyAJq9N2YO.BAwyNeZKjmUO3wFuXm63cvhxpxQgEdiycen2u', 'TEACHER', 'sava');
INSERT INTO users VALUES (8, FALSE, '$2y$12$Mc18SERn7ApL.eLZlz82k.qIYhMwDTLtbr4Q40eGkKSTgXV5mN/vq', 'TEACHER', 'nada');
INSERT INTO users VALUES (9, FALSE, '$2y$12$HfBltKNCBn9ENiL6jIemZuSrKBpUb1zWP6aGwY2/nWOjpGMktgkPu', 'TEACHER', 'paja');
INSERT INTO users VALUES (10, FALSE, '$2y$12$ThSoGHO/V6kPvMFgDkTYNO5QfMZF93.NZRFfS1twlJ5GkA1fscLcK', 'ADMIN', 'admin');

INSERT INTO students VALUES (1, 1000.0, FALSE, 'Filip', 'sf01', 'Stojisavljevic', 1);
INSERT INTO students VALUES (2, 1000.0, FALSE, 'Gabrijela', 'sf02', 'Tadic', 2);
INSERT INTO students VALUES (3, 1000.0, FALSE, 'Bogdan', 'sf03', 'Bogdanovic', 3);
INSERT INTO students VALUES (4, 1000.0, FALSE, 'Zoran', 'sf04', 'Pavlovic', 4);
INSERT INTO students VALUES (5, 1000.0, FALSE, 'Kosta', 'sf05', 'Kostic', 5);
INSERT INTO students VALUES (6, 1000.0, FALSE, 'Miroslav', 'sf06', 'Braduljica', 6);

INSERT INTO teachers VALUES (1, FALSE, 'Sava', 'Sumanovic', 7);
INSERT INTO teachers VALUES (2, FALSE, 'Nadezda', 'Miljkovic', 8);
INSERT INTO teachers VALUES (3, FALSE, 'Pavle', 'Markovic', 9);

INSERT INTO courses VALUES (1, FALSE, 'Osnove web programiranja');
INSERT INTO courses VALUES (2, FALSE, 'Programiranje mobilnih sistema');
INSERT INTO courses VALUES (3, FALSE, 'Matematika');
INSERT INTO courses VALUES (4, FALSE, 'Osnove web dizajna');
INSERT INTO courses VALUES (5, FALSE, 'Engleski jezik');
INSERT INTO courses VALUES (6, FALSE, 'Uvod u razvoj softvera');
INSERT INTO courses VALUES (7, FALSE, 'Uvod u objektno programiranje');
INSERT INTO courses VALUES (8, FALSE, 'Osnove programiranja');

INSERT INTO teacher_engagements VALUES (1, FALSE, 'PROFESSOR', 1, 1);
INSERT INTO teacher_engagements VALUES (2, FALSE, 'ASSISTANT', 1, 2);
INSERT INTO teacher_engagements VALUES (3, FALSE, 'PROFESSOR', 2, 3);
INSERT INTO teacher_engagements VALUES (4, FALSE, 'ASSISTANT', 2, 1);
INSERT INTO teacher_engagements VALUES (5, FALSE, 'PROFESSOR', 3, 2);
INSERT INTO teacher_engagements VALUES (6, FALSE, 'ASSISTANT', 3, 3);
INSERT INTO teacher_engagements VALUES (7, FALSE, 'PROFESSOR', 4, 1);
INSERT INTO teacher_engagements VALUES (8, FALSE, 'ASSISTANT', 4, 2);
INSERT INTO teacher_engagements VALUES (9, FALSE, 'PROFESSOR', 5, 3);
INSERT INTO teacher_engagements VALUES (10, FALSE, 'ASSISTANT', 5, 1);
INSERT INTO teacher_engagements VALUES (11, FALSE, 'PROFESSOR', 6, 2);
INSERT INTO teacher_engagements VALUES (12, FALSE, 'ASSISTANT', 6, 3);
INSERT INTO teacher_engagements VALUES (13, FALSE, 'PROFESSOR', 7, 1);
INSERT INTO teacher_engagements VALUES (14, FALSE, 'ASSISTANT', 7, 2);
INSERT INTO teacher_engagements VALUES (15, FALSE, 'PROFESSOR', 8, 3);
INSERT INTO teacher_engagements VALUES (16, FALSE, 'ASSISTANT', 8, 1);

INSERT INTO course_enrollments VALUES (1, FALSE, 1, 1);
INSERT INTO course_enrollments VALUES (2, FALSE, 1, 2);
INSERT INTO course_enrollments VALUES (3, FALSE, 1, 3);
INSERT INTO course_enrollments VALUES (4, FALSE, 1, 4);
INSERT INTO course_enrollments VALUES (5, FALSE, 2, 5);
INSERT INTO course_enrollments VALUES (6, FALSE, 2, 6);
INSERT INTO course_enrollments VALUES (7, FALSE, 2, 1);
INSERT INTO course_enrollments VALUES (8, FALSE, 2, 2);
INSERT INTO course_enrollments VALUES (9, FALSE, 3, 3);
INSERT INTO course_enrollments VALUES (10, FALSE, 3, 4);
INSERT INTO course_enrollments VALUES (11, FALSE, 3, 5);
INSERT INTO course_enrollments VALUES (12, FALSE, 3, 6);
INSERT INTO course_enrollments VALUES (13, FALSE, 4, 1);
INSERT INTO course_enrollments VALUES (14, FALSE, 4, 2);
INSERT INTO course_enrollments VALUES (15, FALSE, 4, 3);
INSERT INTO course_enrollments VALUES (16, FALSE, 4, 4);
INSERT INTO course_enrollments VALUES (17, FALSE, 5, 5);
INSERT INTO course_enrollments VALUES (18, FALSE, 5, 6);
INSERT INTO course_enrollments VALUES (19, FALSE, 5, 1);
INSERT INTO course_enrollments VALUES (20, FALSE, 5, 2);
INSERT INTO course_enrollments VALUES (21, FALSE, 6, 3);
INSERT INTO course_enrollments VALUES (22, FALSE, 6, 4);
INSERT INTO course_enrollments VALUES (23, FALSE, 6, 5);
INSERT INTO course_enrollments VALUES (24, FALSE, 6, 6);
INSERT INTO course_enrollments VALUES (25, FALSE, 7, 1);
INSERT INTO course_enrollments VALUES (26, FALSE, 7, 2);
INSERT INTO course_enrollments VALUES (27, FALSE, 7, 3);
INSERT INTO course_enrollments VALUES (28, FALSE, 7, 4);
INSERT INTO course_enrollments VALUES (29, FALSE, 8, 5);
INSERT INTO course_enrollments VALUES (30, FALSE, 8, 6);
INSERT INTO course_enrollments VALUES (31, FALSE, 8, 1);
INSERT INTO course_enrollments VALUES (32, FALSE, 8, 2);


INSERT INTO terms VALUES (1, FALSE, '2020-01-30', '2020-01-01', 'JANUARY');
INSERT INTO terms VALUES (2, FALSE, '2020-06-30', '2020-06-01', 'JUNE');
INSERT INTO terms VALUES (3, FALSE, '2020-09-30', '2020-09-01', 'SEPTEMBER');

INSERT INTO exams VALUES (1, '2020-01-02 09:00:00', FALSE, 'pc32', 300.0, 1, 1);
INSERT INTO exams VALUES (2, '2020-06-02 11:00:00', FALSE, 'pc33', 300.0, 1, 2);
INSERT INTO exams VALUES (3, '2020-09-04 12:00:00', FALSE, 'pc34', 300.0, 1, 3);
INSERT INTO exams VALUES (4, '2020-01-07 16:00:00', FALSE, 'pc31', 300.0, 2, 1);
INSERT INTO exams VALUES (5, '2020-06-05 19:00:00', FALSE, 'pc39', 300.0, 2, 2);
INSERT INTO exams VALUES (6, '2020-09-14 08:00:00', FALSE, 'pc40', 300.0, 2, 3);
INSERT INTO exams VALUES (7, '2020-01-15 09:00:00', FALSE, 'pc32', 300.0, 3, 1);
INSERT INTO exams VALUES (8, '2020-06-12 11:00:00', FALSE, 'pc33', 300.0, 3, 2);
INSERT INTO exams VALUES (9, '2020-09-15 12:00:00', FALSE, 'pc34', 300.0, 3, 3);
INSERT INTO exams VALUES (10, '2020-01-20 09:00:00', FALSE, 'pc32', 300.0, 4, 1);
INSERT INTO exams VALUES (11, '2020-06-16 11:00:00', FALSE, 'pc33', 300.0, 4, 2);
INSERT INTO exams VALUES (12, '2020-09-21 12:00:00', FALSE, 'pc34', 300.0, 4, 3);
INSERT INTO exams VALUES (13, '2020-01-21 09:00:00', FALSE, 'pc32', 300.0, 5, 1);
INSERT INTO exams VALUES (14, '2020-06-23 11:00:00', FALSE, 'pc33', 300.0, 5, 2);
INSERT INTO exams VALUES (15, '2020-09-22 12:00:00', FALSE, 'pc34', 300.0, 5, 3);
INSERT INTO exams VALUES (16, '2020-01-24 09:00:00', FALSE, 'pc32', 300.0, 6, 1);
INSERT INTO exams VALUES (17, '2020-06-25 11:00:00', FALSE, 'pc33', 300.0, 6, 2);
INSERT INTO exams VALUES (18, '2020-09-24 12:00:00', FALSE, 'pc34', 300.0, 6, 3);
INSERT INTO exams VALUES (19, '2020-01-28 09:00:00', FALSE, 'pc32', 300.0, 7, 1);
INSERT INTO exams VALUES (20, '2020-06-29 11:00:00', FALSE, 'pc33', 300.0, 7, 2);
INSERT INTO exams VALUES (21, '2020-09-25 12:00:00', FALSE, 'pc34', 300.0, 7, 3);
INSERT INTO exams VALUES (22, '2020-01-29 09:00:00', FALSE, 'pc32', 300.0, 8, 1);
INSERT INTO exams VALUES (23, '2020-06-30 11:00:00', FALSE, 'pc33', 300.0, 8, 2);
INSERT INTO exams VALUES (24, '2020-09-28 12:00:00', FALSE, 'pc34', 300.0, 8, 3);

INSERT INTO exam_registrations VALUES (1, 22, FALSE, 30, 6, TRUE, 'PASSED', 1, 1);
INSERT INTO exam_registrations VALUES (2, 30, FALSE, 31, 7, TRUE, 'PASSED', 5, 2);
INSERT INTO exam_registrations VALUES (3, 41, FALSE, 50, 10, TRUE, 'PASSED', 9, 3);
INSERT INTO exam_registrations VALUES (4, 30, FALSE, 21, 6, TRUE, 'PASSED', 13, 4);
INSERT INTO exam_registrations VALUES (5, 22, FALSE, 30, 6, TRUE, 'PASSED', 17, 5);
INSERT INTO exam_registrations VALUES (6, 30, FALSE, 51, 9, TRUE, 'PASSED', 23, 6);

