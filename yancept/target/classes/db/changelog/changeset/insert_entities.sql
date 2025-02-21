INSERT INTO students (first_name, second_name, patronymic, course_name, mentor_id, about_me)
VALUES
    ('Ivan', 'SecondName', 'Patronymic', '4243-100501D', 1, 'About John Doe'),
    ('Oleg', 'SecondName', 'Patronymic', '6666-100501D', 2, 'About John Doe'),
    ('Grisha', 'SecondName', 'Patronymic', '4444-100501D', 3, 'About John Doe'),
    ('Nikita', 'SecondName', 'Patronymic', '3333-100501D', 1, 'About John Doe'),
    ('Egor', 'SecondName', 'Patronymic', '2222-100501D', 1, 'About John Doe'),
    ('Vlad', 'SecondName', 'Patronymic', '1111-100501D', 4, 'About John Doe');

INSERT INTO teachers (first_name, second_name, patronymic, link_to_profile, about_me)
VALUES
    ('Teacher1', 'SecondName', 'Patronymic', 'link', 'About'),
    ('Teacher2', 'SecondName', 'Patronymic', 'link', 'About'),
    ('Teacher3', 'SecondName', 'Patronymic', 'link', 'About'),
    ('Teacher4', 'SecondName', 'Patronymic', 'link', 'About'),
    ('Teacher5', 'SecondName', 'Patronymic', 'link', 'About'),
    ('Teacher6', 'SecondName', 'Patronymic', 'link', 'About');

INSERT INTO projects (name, description, owner_id, created_at)
VALUES
    ('math', 'description', 1, CURRENT_TIMESTAMP),
    ('russian', 'description', 1, CURRENT_TIMESTAMP),
    ('german', 'description', 2, CURRENT_TIMESTAMP),
    ('english', 'description', 3, CURRENT_TIMESTAMP),
    ('php', 'description', 3, CURRENT_TIMESTAMP),
    ('history', 'description', 4, CURRENT_TIMESTAMP);

INSERT INTO requests (description, requester_id, receiver_id, is_accepted, created_at)
VALUES
    ('description', 1, 1, false, CURRENT_TIMESTAMP),
    ('description', 1, 2, false, CURRENT_TIMESTAMP),
    ('description', 2, 2, false, CURRENT_TIMESTAMP),
    ('description', 3, 3, false, CURRENT_TIMESTAMP),
    ('description', 3, 4, false, CURRENT_TIMESTAMP),
    ('description', 4, 5, false, CURRENT_TIMESTAMP);