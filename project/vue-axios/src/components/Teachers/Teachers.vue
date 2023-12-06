<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">

    <Title>Teachers List</Title>
    <div>
      <div class="teachers">
        <div v-for="(teacher, index) in teachers" v-bind:key="teacher.id" class="teacher">
          <div >Teacher ID: {{ teacher.id }}</div>
          <div >Name: {{ teacher.name}}</div>
          <div >Surname: {{ teacher.surname}}</div>
          <div >Email: {{ teacher.email}}</div>
          <div >Phone: +{{ teacher.phone}}</div>

          <button-style @click="$emit('removeTeacher', teacher.id)"><i class="fa fa-trash"></i> Trash</button-style>

          <button-style @click="showDialog(index)"><i class="fa fa-bars"></i> Edit</button-style>
          <create-dialog-page v-model:show="dialogVisible[index]">
            <form-edit-teacher :teacher="teacher"
                               @editTeacher="edit"/>
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
import FormTeacher from "@/components/Teachers/Form-teacher.vue";
import FormEditTeacher from "@/components/Teachers/FormEditTeacher.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Teachers",
  components: {ButtonStyle, TableStyle, CreateDialogPage, FormTeacher, FormEditTeacher, Title},
  data() {
    return {
      dialogVisible: [],
    }
  },
  props: {
    teachers: {
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedTeacher) {
      this.$emit('editTeacher', changedTeacher);
      this.dialogVisible = [];
    },
    showDialog(index) {
      this.dialogVisible[index] = true;
    },
  },
}
</script>

<style scoped>
.teacher{
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

.teachers {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}
</style>