import axios from "axios";
const DISCIPLINES_API_BASE_URL='http://localhost:8080/disciplines'
class DisciplineService{
    getDisciplines(){
        return axios.get(DISCIPLINES_API_BASE_URL);
    }
    getDiscipline(id){
        return axios.get(DISCIPLINES_API_BASE_URL+  '/'+id);
    }
    insertDiscipline(discipline){
        return axios.post(DISCIPLINES_API_BASE_URL, discipline);
    }
    updateDiscipline(discipline){
        return axios.put(DISCIPLINES_API_BASE_URL, discipline);
    }
    deleteDiscipline(id){
        return axios.delete(DISCIPLINES_API_BASE_URL + '/'+id);
    }
}
export default new DisciplineService()