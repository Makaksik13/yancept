const { createApp } = Vue;

createApp({
    data() {
        return {
            selectedStudents: [
                { id: 1, name: 'Студент 1', application: 'Хочу работать над ИИ' }
            ],
            applications: [
                { id: 2, name: 'Студент 2', application: 'Интересуюсь квантовыми вычислениями' }
            ]
        };
    },
    methods: {
        acceptApplication(studentId) {
            const application = this.applications.find(app => app.id === studentId);
            if (application) {
                this.selectedStudents.push(application);
                this.applications = this.applications.filter(app => app.id !== studentId);
                alert(`Заявка студента ${studentId} принята`);
            }
        },
        rejectApplication(studentId) {
            this.applications = this.applications.filter(app => app.id !== studentId);
            alert(`Заявка студента ${studentId} отклонена`);
        }
    }
}).mount('#app');