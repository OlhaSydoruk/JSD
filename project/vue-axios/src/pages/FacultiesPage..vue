<template>
  <div class="main">
    <button-style @click="showDialog">Create faculty</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-faculty
          @createFaculty="insertFaculty"
      />
    </create-dialog-page>
    <Faculties :faculties="this.faculties"
             @removeFaculty="deleteFaculty"
             @editFaculty="updateFaculty"/>
  </div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import FacultyService from "@/services/FacultyService";
import Faculties from "@/components/Faculties/Faculties.vue";
import FormFaculty from "@/components/Faculties/Form-faculty.vue";

export default {
  name: "FacultiesPage",
  components: {FormFaculty, ButtonStyle,  CreateDialogPage,Faculties },
 ButtonStyle,FormFaculty,
  data() {
    return {
      dialogVisible: false,
      faculty: "",
      faculties: []
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateFaculty(faculty){
      FacultyService.updateFaculty(faculty).then((response)=>{
        console.log(response);
        this.dialogVisible=false;
        this.getFaculties();
      })
    },

    insertFaculty(faculty) {
      FacultyService.insertFaculty(faculty).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getFaculties();
      })
    },
    getFaculties() {
      FacultyService.getFaculties().then((response) => {
        console.log(response);
        this.faculties = response.data;
      })
    },
    deleteFaculty(id) {
      FacultyService.deleteFaculty(id).then((response) => {
        console.log(response);
        this.getFaculties();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getFaculties()
  }
}
</script>

<style scoped>

</style>