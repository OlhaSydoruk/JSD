import axios from "axios";
const STUDENT_API_BASE_URL='http://localhost:8080/students'
 class StudentService{
    getStudents(){
        return axios.get(STUDENT_API_BASE_URL);
    }
     getStudent(id){
         return axios.get(STUDENT_API_BASE_URL + `/${id}`);
     }
     insertStudent(student){
         return axios.post(STUDENT_API_BASE_URL, student);
     }
     updateStudent(student){
         return axios.put(STUDENT_API_BASE_URL, student);
     }
     deleteStudent(id){
         return axios.delete(STUDENT_API_BASE_URL + `/${id}`);
     }
 }
 export default new StudentService()