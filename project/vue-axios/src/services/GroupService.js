import axios from "axios";
const GROUPS_API_BASE_URL='http://localhost:8080/groups'
class GroupService{
    getGroups(){
        return axios.get(GROUPS_API_BASE_URL);
    }
    getGroup(id){
        return axios.get(GROUPS_API_BASE_URL + `/${id}`);
    }
    insertGroup(group){
        return axios.post(GROUPS_API_BASE_URL, group);
    }
    updateGroup(group){
        return axios.put(GROUPS_API_BASE_URL, group);
    }
    deleteGroup(id){
        return axios.delete(GROUPS_API_BASE_URL + `/${id}`);
    }
}
export default new GroupService()