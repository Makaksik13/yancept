ALTER TABLE students
ALTER COLUMN course_name SET NOT NULL;

INSERT INTO students (first_name, second_name, patronymic, course_name, about_me)
VALUES
    ('Peter', 'SecondName', 'Patronymic', '4243-100501D',  'About John Doe'),
    ('Sartir', 'SecondName', 'Patronymic', '6666-100501D', 'About John Doe');
