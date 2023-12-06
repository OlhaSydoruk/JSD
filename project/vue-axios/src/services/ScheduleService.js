import axios from "axios";
const SCHEDULE_API_BASE_URL='http://localhost:8080/schedules'
class ScheduleService{
    getSchedules(){
        return axios.get(SCHEDULE_API_BASE_URL);
    }
    getSchedule(id){
        return axios.get(SCHEDULE_API_BASE_URL + `/${id}`);
    }
    insertSchedule(schedule){
        return axios.post(SCHEDULE_API_BASE_URL, schedule);
    }
    updateSchedule(schedule){
        return axios.put(SCHEDULE_API_BASE_URL, schedule);
    }
    deleteSchedule(id){
        return axios.delete(SCHEDULE_API_BASE_URL + `/${id}`);
    }
}
export default new ScheduleService()