"use strict";
// Класс для заявки
class Application {
    constructor(id, student, teacher, coverLetter, date) {
        this.id = id;
        this.student = student;
        this.teacher = teacher;
        this.coverLetter = coverLetter;
        this.date = date;
    }
}
// Класс для студента
class Student {
    constructor(id, fullName, course, specialty, group) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.specialty = specialty;
        this.group = group;
        this.selectedTeacher = null;
        this.applications = [];
    }
    sendApplication(teacher, coverLetter) {
        const application = new Application(this.applications.length + 1, this, teacher, coverLetter, new Date());
        this.applications.push(application);
        teacher.applications.push(application);
        this.selectedTeacher = teacher;
        this.saveToLocalStorage();
    }
    cancelApplication(applicationId) {
        this.applications = this.applications.filter(app => app.id !== applicationId);
        this.selectedTeacher = null;
        this.saveToLocalStorage();
    }
    saveToLocalStorage() {
        localStorage.setItem(`student_${this.id}`, JSON.stringify(this));
    }
}
// Класс для преподавателя
class Teacher {
    constructor(id, fullName, description, profileLink, projectTopics, requirements) {
        this.id = id;
        this.fullName = fullName;
        this.description = description;
        this.profileLink = profileLink;
        this.projectTopics = projectTopics;
        this.requirements = requirements;
        this.selectedStudents = [];
        this.applications = [];
    }
    acceptApplication(applicationId) {
        const application = this.applications.find(app => app.id === applicationId);
        if (application) {
            this.selectedStudents.push(application.student);
            this.applications = this.applications.filter(app => app.id !== applicationId);
            this.saveToLocalStorage();
        }
    }
    rejectApplication(applicationId) {
        this.applications = this.applications.filter(app => app.id !== applicationId);
        this.saveToLocalStorage();
    }
    saveToLocalStorage() {
        localStorage.setItem(`teacher_${this.id}`, JSON.stringify(this));
    }
}
