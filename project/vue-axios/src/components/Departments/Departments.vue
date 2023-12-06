<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <div class="table-container">
      <Title>Departments List</Title>
      <div>
        <div class="departments">
          <div v-for="(department, index) in departments" v-bind:key="department.id" class="department">
            <div >Department ID: {{ department.id }}</div>
            <div >Name: {{ department.name}}</div>
            <div >Faculty ID: {{ department.facultyId }}</div>
            <div >Short Name: {{ department.shortName }}</div>
            <button-style @click="$emit('removeDepartment', department.id)"><i class="fa fa-trash"></i> Trash</button-style>

            <button-style @click="showDialog(index)"><i class="fa fa-bars"></i> Edit</button-style>
            <create-dialog-page v-model:show="dialogVisible[index]">
              <form-edit-department :department="department"
                                    :faculties="faculties"
                                    @editDepartment="edit"/>
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
import FormEditDepartment from "@/components/Departments/FormEditDepartment.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Departments",
  components: {ButtonStyle, TableStyle, CreateDialogPage, FormEditDepartment,Title},
  data() {
    return {
      dialogVisible: [],
    }
  },
  props: {
    departments: {
      type: Array,
      required: true
    },
    faculties:{
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedDepartment) {
      this.$emit('editDepartment', changedDepartment);
      this.dialogVisible = [];
    },
    showDialog(index) {
      this.dialogVisible[index] = true;
    },


  },
}
</script>

<style scoped>
.department{
  margin: 2%;
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

.departments {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}


</style>