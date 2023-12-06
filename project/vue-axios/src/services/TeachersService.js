import axios from "axios";
const TEACHERS_API_BASE_URL='http://localhost:8080/teachers'
class TeachersService{
    getTeachers(){
        return axios.get(TEACHERS_API_BASE_URL);
    }
    getTeacher(id){
        return axios.get(TEACHERS_API_BASE_URL + `/${id}`);
    }
    insertTeacher(teacher){
        return axios.post(TEACHERS_API_BASE_URL, teacher);
    }
    updateTeacher(teacher){
        return axios.put(TEACHERS_API_BASE_URL, teacher);
    }
    deleteTeacher(id){
        return axios.delete(TEACHERS_API_BASE_URL + `/${id}`);
    }
}
export default new TeachersService()