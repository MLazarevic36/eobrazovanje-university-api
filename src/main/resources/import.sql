INSERT INTO users VALUES (1, FALSE, '$2y$12$Zo.7T6sxERtrOOYjkBTEX.NulXfviEQsKOXEKQ99n/IKyqYxJTO8.', 'STUDENT', 'mile');
INSERT INTO users VALUES (2, FALSE, '$2y$12$0wrqOMcG4lRQE3oBfnH55eiwk4PrTvufh1Js.waLm1YZdNxeGRXnq', 'STUDENT', 'student');
INSERT INTO users VALUES (3, FALSE, '$2y$12$1XoO6QguCvM7yupJG70kPuNFvLDd2SIkBcytAOGITDHUyNh4BItXy', 'TEACHER', 'sava');
INSERT INTO users VALUES (4, FALSE, '$2y$12$ThSoGHO/V6kPvMFgDkTYNO5QfMZF93.NZRFfS1twlJ5GkA1fscLcK', 'ADMIN', 'admin');
INSERT INTO users VALUES (5, FALSE, '$2y$12$GIKCkpXVo.o76hzEdka2oetUpdHGbFOuEyunmgW.EixnUITuoK79.', 'TEACHER', 'teacher');


INSERT INTO students VALUES (1, 1000.0, FALSE, 'miloslav', 'sf828282', 'kitic', 1);
INSERT INTO students VALUES (2, 1000.0, FALSE, 'student', 'sf299229', 'student', 2);

INSERT INTO teachers VALUES (1, FALSE, 'stevan', 'stevanovic', 5);
INSERT INTO teachers VALUES (2, FALSE, 'sava', 'sumanovic', 3);

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
INSERT INTO teacher_engagements VALUES (3, FALSE, 'PROFESSOR', 2, 2);
INSERT INTO teacher_engagements VALUES (4, FALSE, 'ASSISTANT', 2, 1);
INSERT INTO teacher_engagements VALUES (5, FALSE, 'PROFESSOR', 3, 1);
INSERT INTO teacher_engagements VALUES (6, FALSE, 'ASSISTANT', 3, 2);
INSERT INTO teacher_engagements VALUES (7, FALSE, 'PROFESSOR', 4, 2);
INSERT INTO teacher_engagements VALUES (8, FALSE, 'ASSISTANT', 4, 1);

INSERT INTO course_enrollments VALUES (1, FALSE, 1, 1);
INSERT INTO course_enrollments VALUES (2, FALSE, 2, 1);
INSERT INTO course_enrollments VALUES (3, FALSE, 3, 1);
INSERT INTO course_enrollments VALUES (4, FALSE, 4, 1);
INSERT INTO course_enrollments VALUES (5, FALSE, 1, 2);
INSERT INTO course_enrollments VALUES (6, FALSE, 2, 2);

INSERT INTO terms VALUES (1, FALSE, '2020-01-30', '2020-01-01', 'JANUARY');
INSERT INTO terms VALUES (2, FALSE, '2020-06-30', '2020-06-01', 'JUNE');
INSERT INTO terms VALUES (3, FALSE, '2020-09-30', '2020-09-01', 'SEPTEMBER');

INSERT INTO exams VALUES (1, '2020-01-05 09:00:00', FALSE, 'pc32', 300.0, 1, 1);
INSERT INTO exams VALUES (2, '2020-06-10 11:00:00', FALSE, 'pc33', 300.0, 1, 2);
INSERT INTO exams VALUES (3, '2020-09-15 12:00:00', FALSE, 'pc34', 300.0, 1, 3);
INSERT INTO exams VALUES (4, '2020-01-09 16:00:00', FALSE, 'pc31', 300.0, 2, 1);
INSERT INTO exams VALUES (5, '2020-06-11 19:00:00', FALSE, 'pc39', 300.0, 2, 2);
INSERT INTO exams VALUES (6, '2020-09-15 08:00:00', FALSE, 'pc40', 300.0, 2, 3);
INSERT INTO exams VALUES (7, '2020-01-20 09:00:00', FALSE, 'pc32', 300.0, 3, 1);
INSERT INTO exams VALUES (8, '2020-06-15 11:00:00', FALSE, 'pc33', 300.0, 3, 2);
INSERT INTO exams VALUES (9, '2020-09-21 12:00:00', FALSE, 'pc34', 300.0, 3, 3);


INSERT INTO exam_registrations VALUES (1, 0, FALSE, 0, 5, TRUE, 'ACTIVE', 1, 1);
INSERT INTO exam_registrations VALUES (2, 22, FALSE, 30, 6, TRUE, 'PASSED', 4, 1);
INSERT INTO exam_registrations VALUES (3, 0, FALSE, 0, 0, TRUE, 'ACTIVE', 4, 2);
INSERT INTO exam_registrations VALUES (4, 30, FALSE, 51, 9, TRUE, 'PASSED', 2, 2);
