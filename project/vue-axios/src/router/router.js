import { createRouter, createWebHistory } from 'vue-router/dist/vue-router.esm-bundler'
import Students from "@/pages/StudentsPage.vue";
import Disciplines from "@/pages/DisciplinesPage.vue";
import Faculties from "@/pages/FacultiesPage..vue";
import Departments from "@/pages/DepartmentsPage.vue";
import Teachers from "@/pages/TeachersPage..vue";
import Groups from "@/pages/GroupsPage.vue";
import Schedules from "@/pages/SchedulesPage.vue";
import News from "@/pages/NewsPage.vue"
const routes = [
    {
        path:'/',
        name: News,
        component: News
    },
    {
        path:'/students',
        name: Students,
        component: Students
    },
    {
        path:'/disciplines',
        name: Disciplines,
        component: Disciplines
    },
    {
        path:'/schedules',
        name: Schedules,
        component: Schedules
    },
    {
        path:'/faculties',
        name: Faculties ,
        component: Faculties
    },
    {
        path:'/groups',
        name: Groups ,
        component: Groups
    },
    {
        path:'/departments',
        name: Departments,
        component: Departments
    },
    {
        path:'/teachers',
        name: Teachers ,
        component: Teachers
    },
    {
        path:'/news',
        name: News ,
        component: News
    },

    ]
export default ()=> createRouter({
    history: createWebHistory(),
    routes: routes
})