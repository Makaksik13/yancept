INSERT INTO teachers (first_name, second_name, patronymic, link_to_profile, about_me)
VALUES
    ('Alexey', 'Morozov', 'Vladimirovich', 'https://example.com/morozov', 'Mathematics teacher with a focus on problem-solving techniques.'),
    ('Natalia', 'Sokolova', 'Ivanovna', 'https://example.com/sokolova', 'Literature teacher passionate about classical novels.'),
    ('Dmitry', 'Volkov', 'Petrovich', 'https://example.com/volkov', 'Physics teacher with expertise in quantum mechanics.'),
    ('Elena', 'Orlova', 'Sergeevna', 'https://example.com/orlova', 'Biology teacher specializing in genetics and evolution.'),
    ('Pavel', 'Gusev', 'Anatolievich', 'https://example.com/gusev', 'Chemistry teacher with a focus on organic chemistry.'),
    ('Svetlana', 'Krylova', 'Olegovna', 'https://example.com/krylova', 'History teacher with a deep interest in ancient civilizations.'),
    ('Andrey', 'Belyaev', 'Dmitrievich', 'https://example.com/belyaev', 'Computer science teacher specializing in algorithms and data structures.'),
    ('Yulia', 'Gorbacheva', 'Viktorovna', 'https://example.com/gorbacheva', 'English teacher with a focus on business communication.'),
    ('Vladimir', 'Kuzmin', 'Alexandrovich', 'https://example.com/kuzmin', 'Geography teacher with expertise in climatology.'),
    ('Tatiana', 'Fedorova', 'Mikhailovna', 'https://example.com/fedorova', 'Art teacher inspiring students through modern art techniques.');

INSERT INTO students (first_name, second_name, patronymic, course_name, mentor_id, about_me)
VALUES
    ('Ivanov', 'Aleksandr', 'Sergeevich', '1111-100501D', 1, 'About Ivanov Aleksandr Sergeevich'),
    ('Petrova', 'Ekaterina', 'Dmitrievna', '2222-100501D', 2, 'About Petrova Ekaterina Dmitrievna'),
    ('Sidorov', 'Mikhail', 'Andreevich', '3333-100501D', 3, 'About Sidorov Mikhail Andreevich'),
    ('Kuznetsova', 'Anna', 'Vladimirovna', '4444-100501D', 4, 'About Kuznetsova Anna Vladimirovna'),
    ('Smirnov', 'Denis', 'Igorevich', '5555-100501D', 5, 'About Smirnov Denis Igorevich');

INSERT INTO students (first_name, second_name, patronymic, course_name, about_me)
VALUES
    ('Vasileva', 'Olga', 'Pavlovna', '6666-100501D', 'About Vasileva Olga Pavlovna'),
    ('Popov', 'Artem', 'Nikolaevich', '7777-100501D', 'About Popov Artem Nikolaevich'),
    ('Novikova', 'Tatiana', 'Aleksandrovna', '8888-100501D', 'About Novikova Tatiana Aleksandrovna'),
    ('Lebedev', 'Sergei', 'Viktorovich', '9999-100501D','About Lebedev Sergei Viktorovich'),
    ('Kozlova', 'Marina', 'Olegovna', '0000-100501D', 'About Kozlova Marina Olegovna');

INSERT INTO projects (name, description, owner_id)
VALUES
    ('Math Olympiad Training', 'A project to prepare students for national and international math competitions.', 1),
    ('Literary Analysis Workshop', 'A series of workshops to analyze and discuss classic and modern literature.', 2),
    ('Quantum Physics Research', 'A research project exploring the fundamentals of quantum mechanics.', 3),
    ('Genetics and Evolution Seminar', 'A seminar series on the latest discoveries in genetics and evolutionary biology.', 4),
    ('Organic Chemistry Lab', 'Hands-on experiments and research in organic chemistry.', 5),
    ('Ancient Civilizations Study', 'A project to study the history and culture of ancient civilizations.', 6),
    ('Algorithms and Data Structures Bootcamp', 'An intensive course on algorithms and data structures for computer science students.', 7),
    ('Business English Masterclass', 'A course to improve business communication skills in English.', 8),
    ('Climate Change and Geography', 'A project to study the impact of climate change on different regions.', 9),
    ('Modern Art Techniques Workshop', 'A workshop to explore and practice modern art techniques.', 10);

INSERT INTO requests (description, requester_id, receiver_id, is_accepted)
VALUES
    ('Request to join the Math Olympiad Training project as a participant.', 1, 1, 1),
    ('Request to participate in the Literary Analysis Workshop.', 2, 2, 1),
    ('Request to assist in the Quantum Physics Research project.', 3, 3, 1),
    ('Request to join the Genetics and Evolution Seminar as a presenter.', 4, 4, 1),
    ('Request to participate in the Organic Chemistry Lab experiments.', 5, 5, 1);