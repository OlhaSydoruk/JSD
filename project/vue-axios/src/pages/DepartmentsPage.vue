<template>
  <div class="main">
    <button-style @click="showDialog">Create department</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-department
          :faculties ="this.faculties"
          @createDepartment="insertDepartments"
      />
    </create-dialog-page>
    <departments :departments="this.departments"
                 :faculties ="this.faculties"
                 @removeDepartment="deleteDepartment"
                 @editDepartment="updateDepartment"/>
  </div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import FormDepartment from "@/components/Departments/Form-department.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import DepartmentService from "@/services/DepartmentService";
import Departments from "@/components/Departments/Departments.vue";
import FacultyService from "@/services/FacultyService";


export default {
  name: "DepartmentsPage",
  components: {ButtonStyle, FormDepartment, CreateDialogPage, Departments},
  data() {
    return {
      dialogVisible: false,
      department: "",
      departments: [],
      faculties:[]
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateDepartment(department) {
      DepartmentService.updateDepartment(department).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getDepartments();
      })
    },

    insertDepartments(department) {
      DepartmentService.insertDepartment(department).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getDepartments();
      })
    },
    getFaculties(){
      FacultyService.getFaculties().then((response)=>{
        console.log(response);
        this.faculties = response.data;
      })
    },
    getDepartments() {
      DepartmentService.getDepartments().then((response) => {
        console.log(response);
        this.departments = response.data;
      })
    },
    deleteDepartment(id) {
      DepartmentService.deleteDepartment(id).then((response) => {
        console.log(response);
        this.getDepartments();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getDepartments();
    this.getFaculties()
  }
}
</script>

<style scoped>

</style>