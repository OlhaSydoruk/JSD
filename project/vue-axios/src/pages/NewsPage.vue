<template>
  <div class="main">
    <button-style @click="showDialog">Create news</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-news
          @createNews="insertNews"
      />
    </create-dialog-page>
    <news :newses ="this.newses"
                 @removeNews="deleteNews"
                 @editNews="updateNews"/>
  </div>
</template>

<script>
import FormNews from "@/components/News/Form-news.vue";
import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import News from "@/components/News/News.vue";
import NewsService from "@/services/NewsService";

export default {
  name: "NewsPage",
  components: {FormNews, ButtonStyle,  CreateDialogPage,News},
  ButtonStyle,
  data() {
    return {
      dialogVisible: false,
      news: "",
      newses: []
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateNews(news){
      NewsService.updateNews(news).then((response)=>{
        console.log(response);
        this.dialogVisible=false;
        this.getNews();
      })
    },

    insertNews(news) {
      NewsService.insertNews(news).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getNews();
      })
    },
    getNews() {
      NewsService.getNews().then((response) => {
        console.log(response);
        this.newses = response.data;
      })
    },
    deleteNews(id) {
      NewsService.deleteNews(id).then((response) => {
        console.log(response);
        this.getNews();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getNews()
  }
}

</script>

<style scoped>

</style>