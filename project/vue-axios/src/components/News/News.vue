<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">

    <Title>News List</Title>
    <div>
      <div class="newses">
        <div v-for="(news, index) in newses" v-bind:key="news.id" class="news">
          <div >News ID: {{ news.id }}</div>
          <div >News Text: {{ news.text}}</div>

          <button-style @click="$emit('removeNews', news.id)"><i class="fa fa-trash"></i> Trash</button-style>

          <button-style  @click="showDialog(index)" ><i class="fa fa-bars"></i>  Edit </button-style>
          <create-dialog-page v-model:show="dialogVisible[index]">
            <form-edit-news :news="news"
                            @editNews="edit"/>
          </create-dialog-page>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import TableStyle from "@/components/UI/Table-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import FormEditNews from "@/components/News/FormEditNews.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "News",
  components:{ButtonStyle, TableStyle, CreateDialogPage, FormEditNews,Title},
  data() {
    return {
      dialogVisible:[],
    }
  },
  props: {
    newses: {
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedNews){
      this.$emit('editNews', changedNews);
      this.dialogVisible = [];
    },
    showDialog(index){
      this.dialogVisible[index] = true;
    },
  },
}
</script>

<style scoped>
.news{
  margin: 3%;
  padding: 2%;
  background-color:rgba(0,0,0, 0.7);
  width: 25%;
  height: auto;
  border-radius: 2%;
  box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.8);
  color: navajowhite;
  font-family: 'Caveat', sans-serif;
  border: 1px solid grey;
}

.newses {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}
</style>