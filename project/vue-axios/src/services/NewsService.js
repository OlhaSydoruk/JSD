import axios from "axios";
const NEWS_API_BASE_URL='http://localhost:8080/news'
class NewsService{
    getNews(){
        return axios.get(NEWS_API_BASE_URL);
    }
    getNewsById(id){
        return axios.get(NEWS_API_BASE_URL + `/${id}`);
    }
    insertNews(news){
        return axios.post(NEWS_API_BASE_URL, news);
    }
    updateNews(news){
        return axios.put(NEWS_API_BASE_URL, news);
    }
    deleteNews(id){
        return axios.delete(NEWS_API_BASE_URL + `/${id}`);
    }
}
export default new NewsService()