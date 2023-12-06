<template>
  <div class="main">
    <button-style @click="showDialog">Create discipline</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-discipline
          @createDiscipline="insertDiscipline"
      />
    </create-dialog-page>
    <disciplines :disciplines="this.disciplines"
               @removeDiscipline="deleteDiscipline"
               @editDiscipline="updateDiscipline"/>
  </div>
</template>

<script>


import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import DisciplineService from "@/services/DisciplineService";
import FormDiscipline from "@/components/Disciplines/Form-discipline.vue";
import Disciplines from "@/components/Disciplines/Disciplines.vue";


export default {
  name: "DisciplinesPage",
  components: {FormDiscipline, ButtonStyle,  CreateDialogPage,Disciplines },
  ButtonStyle,
  data() {
    return {
      dialogVisible: false,
      discipline: "",
      disciplines: []
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateDiscipline(discipline){
      DisciplineService.updateDiscipline(discipline).then((response)=>{
        console.log(response);
        this.dialogVisible=false;
        this.getDisciplines();
      })
    },

    insertDiscipline(discipline) {
      DisciplineService.insertDiscipline(discipline).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getDisciplines();
      })
    },
    getDisciplines() {
      DisciplineService.getDisciplines().then((response) => {
        console.log(response);
        this.disciplines = response.data;
      })
    },
    deleteDiscipline(id) {
      DisciplineService.deleteDiscipline(id).then((response) => {
        console.log(response);
        this.getDisciplines();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getDisciplines()
  }

}
</script>

<style scoped>

</style>