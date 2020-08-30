INSERT INTO users VALUES (1, FALSE, '$2y$12$Zo.7T6sxERtrOOYjkBTEX.NulXfviEQsKOXEKQ99n/IKyqYxJTO8.', 'STUDENT', 'mile');
INSERT INTO users VALUES (2, FALSE, 'steva', 'TEACHER', 'steva');
INSERT INTO users VALUES (3, FALSE, '$2y$12$1XoO6QguCvM7yupJG70kPuNFvLDd2SIkBcytAOGITDHUyNh4BItXy', 'TEACHER', 'sava');
INSERT INTO users VALUES (4, FALSE, '$2y$12$ThSoGHO/V6kPvMFgDkTYNO5QfMZF93.NZRFfS1twlJ5GkA1fscLcK', 'ADMIN', 'admin');
-- INSERT INTO users VALUES (2, FALSE, '$10$Mo9d058uPWYq9F2u27NIT.ESnlhLEBOU8FBYzKtFP9olt6rQr7ep2', 'ADMIN', '2', 2);
-- INSERT INTO users VALUES (3, FALSE, '$10$aKcC95Bk8VMnlrMYkY0R.OAROiesUCdQ3/NzVqAz2fXe1GZ9MUknG', 'USER', '3', 3);
-- INSERT INTO users VALUES (4, FALSE, '$2a$10$VONABH7lVE7IIi7l3a9kKeetbzDftLieifQlxbPBNOo35EgzkJZgi', 'USER', '4', 4);

INSERT INTO students VALUES (1, 0.0, FALSE, 'miloslav', 'sf828282', 'kitic', 1);

INSERT INTO teachers VALUES (1, FALSE, 'stevan', 'stevanovic', 2);
INSERT INTO teachers VALUES (2, FALSE, 'sava', 'sumanovic', 3);

INSERT INTO courses VALUES (1, FALSE, 'Osnove web programiranja');
INSERT INTO courses VALUES (2, FALSE, 'Programiranje mobilnih sistema');
INSERT INTO courses VALUES (3, FALSE, 'Matematika');
INSERT INTO courses VALUES (4, FALSE, 'Osnove web dizajna');

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

INSERT INTO exams VALUES (1, FALSE, 0, 'ACTIVE', 1, 1);
INSERT INTO exams VALUES (2, FALSE, 0, 'ACTIVE', 2, 1);
INSERT INTO exams VALUES (3, FALSE, 0, 'ACTIVE', 3, 1);
INSERT INTO exams VALUES (4, FALSE, 0, 'ACTIVE', 4, 1);

INSERT INTO colloquiums VALUES (1, FALSE, 'prvi', 0, 1);
INSERT INTO colloquiums VALUES (2, FALSE, 'drugi', 0, 1);
INSERT INTO colloquiums VALUES (3, FALSE, 'prvi', 0, 2);
INSERT INTO colloquiums VALUES (4, FALSE, 'drugi', 0, 2);
INSERT INTO colloquiums VALUES (5, FALSE, 'prvi', 0, 3);
INSERT INTO colloquiums VALUES (6, FALSE, 'drugi', 0, 3);
INSERT INTO colloquiums VALUES (7, FALSE, 'prvi', 0, 4);
INSERT INTO colloquiums VALUES (8, FALSE, 'drugi', 0, 4);


