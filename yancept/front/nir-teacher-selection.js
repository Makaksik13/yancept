const { createApp } = Vue;

createApp({
    data() {
        return {
            teachers: [
                { id: 1, name: 'Иванов Иван Иванович', avatar: 'avatar1.jpg', topics: 'Искусственный интеллект', requirements: 'Знание Python, машинное обучение' },
                { id: 2, name: 'Петров Петр Петрович', avatar: 'avatar2.jpg', topics: 'Квантовые вычисления', requirements: 'Знание линейной алгебры, квантовая механика' }
            ],
            selectedTeacher: null
        };
    },
    methods: {
        selectTeacher(teacher) {
            this.selectedTeacher = teacher;
        },
        applyForTeacher() {
            alert(`Заявка подана преподавателю: ${this.selectedTeacher.name}`);
            // Здесь можно отправить данные на сервер
            this.selectedTeacher = null;
        },
        cancelSelection() {
            this.selectedTeacher = null;
        }
    }
}).mount('#app');