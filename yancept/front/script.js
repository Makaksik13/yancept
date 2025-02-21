import {Teacher,Student,Application} from './models.js';
// Импорт классов из models.ts
// В реальном проекте нужно скомпилировать TypeScript в JavaScript
// и подключить скомпилированный файл.

// Пример данных
const teachers = [
    new Teacher(1, 'Петров Петр Петрович', 'Профессор', 'link', ['ИИ', 'Кванты'], 'Знание Python'),
    new Teacher(2, 'Сидоров Сидор Сидорович', 'Доцент', 'link', ['Big Data'], 'Знание SQL')
];

const student = new Student(1, 'Иванов Иван Иванович', 3, 'Информатика', 'ИВТ-101');

// Логика для студента
if (document.getElementById('student-name')) {
    document.getElementById('student-name').textContent = student.fullName;

    const teachersDiv = document.getElementById('teachers');
    teachers.forEach(teacher => {
        const teacherDiv = document.createElement('div');
        teacherDiv.className = 'teacher';
        teacherDiv.innerHTML = `
            <h3>${teacher.fullName}</h3>
            <p>${teacher.description}</p>
            <p>Темы проектов: ${teacher.projectTopics.join(', ')}</p>
            <p>Требования: ${teacher.requirements}</p>
        `;
        teacherDiv.addEventListener('click', () => selectTeacher(teacher));
        teachersDiv.appendChild(teacherDiv);
    });

    function selectTeacher(teacher) {
        student.selectedTeacher = teacher;
        document.getElementById('teacher-list').style.display = 'none';
        document.getElementById('selected-teacher').style.display = 'block';
        document.getElementById('selected-teacher-name').textContent = teacher.fullName;
    }

    document.getElementById('send-application').addEventListener('click', () => {
        const coverLetter = document.getElementById('cover-letter').value;
        if (student.selectedTeacher && coverLetter) {
            student.sendApplication(student.selectedTeacher, coverLetter);
            alert('Заявка подана');
        }
    });

    document.getElementById('cancel-application').addEventListener('click', () => {
        if (student.selectedTeacher) {
            const application = student.applications.find(app => app.teacher.id === student.selectedTeacher.id);
            if (application) {
                student.cancelApplication(application.id);
                alert('Заявка отменена');
                document.getElementById('teacher-list').style.display = 'block';
                document.getElementById('selected-teacher').style.display = 'none';
            }
        }
    });
}

// Логика для преподавателя
if (document.getElementById('teacher-name')) {
    const teacher = teachers[0]; // Пример преподавателя
    document.getElementById('teacher-name').textContent = teacher.fullName;

    function renderApplications() {
        const applicationsDiv = document.getElementById('applications');
        applicationsDiv.innerHTML = '';
        teacher.applications.forEach(application => {
            const applicationDiv = document.createElement('div');
            applicationDiv.className = 'application';
            applicationDiv.innerHTML = `
                <h3>${application.student.fullName}</h3>
                <p>${application.coverLetter}</p>
                <button onclick="acceptApplication(${application.id})">Принять</button>
                <button onclick="rejectApplication(${application.id})">Отклонить</button>
            `;
            applicationsDiv.appendChild(applicationDiv);
        });
    }

    function renderSelectedStudents() {
        const selectedStudentsDiv = document.getElementById('selected-students');
        selectedStudentsDiv.innerHTML = '';
        teacher.selectedStudents.forEach(student => {
            const studentDiv = document.createElement('div');
            studentDiv.className = 'student';
            studentDiv.innerHTML = `<h3>${student.fullName}</h3>`;
            selectedStudentsDiv.appendChild(studentDiv);
        });
    }

    window.acceptApplication = function(applicationId) {
        teacher.acceptApplication(applicationId);
        renderApplications();
        renderSelectedStudents();
    };

    window.rejectApplication = function(applicationId) {
        teacher.rejectApplication(applicationId);
        renderApplications();
    };

    renderApplications();
    renderSelectedStudents();
}