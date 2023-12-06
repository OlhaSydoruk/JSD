<template>
  <div class="main">
    <button-style @click="showDialog">Create teacher </button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-teacher
          @createTeacher="insertTeacher"
      />
    </create-dialog-page>
    <Teachers :teachers="this.teachers"
             @removeTeacher="deleteTeacher"
             @editTeacher="updateTeacher"/>
  </div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import Teachers from "@/components/Teachers/Teachers.vue";
import FormTeacher from "@/components/Teachers/Form-teacher.vue";
import TeachersService from "@/services/TeachersService";

export default {
  name: "TeachersPage",
  components: {FormTeacher, ButtonStyle, CreateDialogPage, Teachers},
  data() {
    return {
      dialogVisible: false,
      teacher: "",
      teachers: []
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateTeacher(teacher){
      TeachersService.updateTeacher(teacher).then((response)=>{
        console.log(response);
        this.dialogVisible=false;
        this.getTeachers();
      })
    },

    insertTeacher(teacher) {
      TeachersService.insertTeacher(teacher).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getTeachers();
      })
    },
    getTeachers() {
      TeachersService.getTeachers().then((response) => {
        console.log(response);
        this.teachers = response.data;
      })
    },
    deleteTeacher(id) {
      TeachersService.deleteTeacher(id).then((response) => {
        console.log(response);
        this.getTeachers();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getTeachers();
  }
}
</script>

<style scoped>

</style>