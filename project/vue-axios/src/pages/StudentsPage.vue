<script>
import Student from "@/components/Students/Student.vue";
import StudentService from "@/services/StudentService";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import FormStudent from "@/components/Students/Form-student.vue";
import ButtonStyle from "@/components/UI/Button-style.vue";
import GroupService from "@/services/GroupService";

export default {
  name: "StudentsPage",
  components: {ButtonStyle, FormStudent, CreateDialogPage, Student},
  CreateDialogPage, FormStudent, ButtonStyle,
  data() {
    return {
      dialogVisible: false,
      student: "",
      students: [],
      groups:[]
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateStudent(student){
      StudentService.updateStudent(student).then((response)=>{
        console.log(response);
        this.dialogVisible=false;
        this.getStudents();
          })
    },

  insertStudent(student) {
      StudentService.insertStudent(student).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getStudents();
      })
    },
    getStudents() {
      StudentService.getStudents().then((response) => {
        console.log(response);
        this.students = response.data;
      })
    },
    getGroups(){
      GroupService.getGroups().then((response)=>{
        console.log(response);
        this.groups = response.data;
      })
    },
    deleteStudent(id) {
      StudentService.deleteStudent(id).then((response) => {
        console.log(response);
        this.getStudents();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getStudents();
    this.getGroups();
  }

}

</script>
<template>
  <div class="main">
        <button-style @click="showDialog">Create person</button-style>
        <create-dialog-page v-model:show="dialogVisible">
          <form-student
              @create="insertStudent"
              :groups="this.groups"
          />
        </create-dialog-page>
    <student :students="this.students"
             :groups="this.groups"
             @remove="deleteStudent"
                 @edit="updateStudent"/>
  </div>
</template>


<style scoped>

</style>