// Интерфейс для заявки
interface IApplication {
    id: number;
    student: IStudent;
    teacher: ITeacher;
    coverLetter: string;
    date: Date;
}

// Интерфейс для студента
interface IStudent {
    id: number;
    fullName: string;
    course: number;
    specialty: string;
    group: string;
    selectedTeacher: ITeacher | null;
    applications: IApplication[];
    sendApplication(teacher: ITeacher, coverLetter: string): void;
    cancelApplication(applicationId: number): void;
}

// Интерфейс для преподавателя
interface ITeacher {
    id: number;
    fullName: string;
    description: string;
    profileLink: string;
    projectTopics: string[];
    requirements: string;
    selectedStudents: IStudent[];
    applications: IApplication[];
    acceptApplication(applicationId: number): void;
    rejectApplication(applicationId: number): void;
}

// Класс для заявки
class Application implements IApplication {
    constructor(
        public id: number,
        public student: IStudent,
        public teacher: ITeacher,
        public coverLetter: string,
        public date: Date
    ) {}
}

// Класс для студента
class Student implements IStudent {
    public selectedTeacher: ITeacher | null = null;
    public applications: IApplication[] = [];

    constructor(
        public id: number,
        public fullName: string,
        public course: number,
        public specialty: string,
        public group: string
    ) {}

    sendApplication(teacher: ITeacher, coverLetter: string): void {
        const application = new Application(
            this.applications.length + 1,
            this,
            teacher,
            coverLetter,
            new Date()
        );
        this.applications.push(application);
        teacher.applications.push(application);
        this.selectedTeacher = teacher;
        this.saveToLocalStorage();
    }

    cancelApplication(applicationId: number): void {
        this.applications = this.applications.filter(app => app.id !== applicationId);
        this.selectedTeacher = null;
        this.saveToLocalStorage();
    }

    saveToLocalStorage(): void {
        localStorage.setItem(`student_${this.id}`, JSON.stringify(this));
    }
}

// Класс для преподавателя
class Teacher implements ITeacher {
    public selectedStudents: IStudent[] = [];
    public applications: IApplication[] = [];

    constructor(
        public id: number,
        public fullName: string,
        public description: string,
        public profileLink: string,
        public projectTopics: string[],
        public requirements: string
    ) {}

    acceptApplication(applicationId: number): void {
        const application = this.applications.find(app => app.id === applicationId);
        if (application) {
            this.selectedStudents.push(application.student);
            this.applications = this.applications.filter(app => app.id !== applicationId);
            this.saveToLocalStorage();
        }
    }

    rejectApplication(applicationId: number): void {
        this.applications = this.applications.filter(app => app.id !== applicationId);
        this.saveToLocalStorage();
    }

    saveToLocalStorage(): void {
        localStorage.setItem(`teacher_${this.id}`, JSON.stringify(this));
    }
}