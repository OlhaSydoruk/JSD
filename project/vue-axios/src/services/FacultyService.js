import axios from "axios";
const FACULTY_API_BASE_URL='http://localhost:8080/faculties'
class FacultyService{
    getFaculties(){
        return axios.get(FACULTY_API_BASE_URL);
    }
    getFaculty(id){
        return axios.get(FACULTY_API_BASE_URL + `/${id}`);
    }
    insertFaculty(faculty){
        return axios.post(FACULTY_API_BASE_URL, faculty);
    }
    updateFaculty(faculty){
        return axios.put(FACULTY_API_BASE_URL, faculty);
    }
    deleteFaculty(id){
        return axios.delete(FACULTY_API_BASE_URL + `/${id}`);
    }
}
export default new FacultyService()