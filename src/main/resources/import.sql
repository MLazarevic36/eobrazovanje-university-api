INSERT INTO users VALUES (1, 'mile', 'STUDENT', 'mile');
INSERT INTO users VALUES (2, 'steva', 'TEACHER', 'steva');
INSERT INTO users VALUES (3, 'sava', 'TEACHER', 'sava');
INSERT INTO users VALUES (4, 'admin', 'ADMIN', 'admin');
-- INSERT INTO users VALUES (2, FALSE, '$10$Mo9d058uPWYq9F2u27NIT.ESnlhLEBOU8FBYzKtFP9olt6rQr7ep2', 'ADMIN', '2', 2);
-- INSERT INTO users VALUES (3, FALSE, '$10$aKcC95Bk8VMnlrMYkY0R.OAROiesUCdQ3/NzVqAz2fXe1GZ9MUknG', 'USER', '3', 3);
-- INSERT INTO users VALUES (4, FALSE, '$2a$10$VONABH7lVE7IIi7l3a9kKeetbzDftLieifQlxbPBNOo35EgzkJZgi', 'USER', '4', 4);

INSERT INTO students VALUES (1, 0.0, 'miloslav', 'sf828282', 'kitic', 1);

INSERT INTO teachers VALUES (1, 'stevan', 'stevanovic', 2);
INSERT INTO teachers VALUES (2, 'sava', 'sumanovic', 3);

INSERT INTO courses VALUES (1, 'Osnove web programiranja');
INSERT INTO courses VALUES (2, 'Programiranje mobilnih sistema');
INSERT INTO courses VALUES (3, 'Matematika');
INSERT INTO courses VALUES (4, 'Osnove web dizajna');

INSERT INTO teacher_engagements VALUES (1, 'PROFESSOR', 1, 1);
INSERT INTO teacher_engagements VALUES (2, 'ASSISTANT', 1, 2);
INSERT INTO teacher_engagements VALUES (3, 'PROFESSOR', 2, 2);
INSERT INTO teacher_engagements VALUES (4, 'ASSISTANT', 2, 1);
INSERT INTO teacher_engagements VALUES (5, 'PROFESSOR', 3, 1);
INSERT INTO teacher_engagements VALUES (6, 'ASSISTANT', 3, 2);
INSERT INTO teacher_engagements VALUES (7, 'PROFESSOR', 4, 2);
INSERT INTO teacher_engagements VALUES (8, 'ASSISTANT', 4, 1);

INSERT INTO course_enrollments VALUES (1, 1, 1);
INSERT INTO course_enrollments VALUES (2, 2, 1);
INSERT INTO course_enrollments VALUES (3, 3, 1);
INSERT INTO course_enrollments VALUES (4, 4, 1);

INSERT INTO exams VALUES (1, 0, 'ACTIVE', 1, 1);
INSERT INTO exams VALUES (2, 0, 'ACTIVE', 2, 1);
INSERT INTO exams VALUES (3, 0, 'ACTIVE', 3, 1);
INSERT INTO exams VALUES (4, 0, 'ACTIVE', 4, 1);

INSERT INTO colloquiums VALUES (1, 'prvi', 0, 1);
INSERT INTO colloquiums VALUES (2, 'drugi', 0, 1);
INSERT INTO colloquiums VALUES (3, 'prvi', 0, 2);
INSERT INTO colloquiums VALUES (4, 'drugi', 0, 2);
INSERT INTO colloquiums VALUES (5, 'prvi', 0, 3);
INSERT INTO colloquiums VALUES (6, 'drugi', 0, 3);
INSERT INTO colloquiums VALUES (7, 'prvi', 0, 4);
INSERT INTO colloquiums VALUES (8, 'drugi', 0, 4);


