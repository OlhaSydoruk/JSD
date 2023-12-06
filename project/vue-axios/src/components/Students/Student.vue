<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">
    <Title>Student List</Title>
    <div>
      <div class="students">
        <div v-for="(student, index) in students" v-bind:key="student.id" class="student">
          <div class="student-item">Name: {{ student.name }}</div>
          <div class="student-item">Group Id: {{ student.groupId }}</div>
          <div class="student-item">Email: {{ student.email }}</div>
          <div class="student-item">Phone: +{{ student.phone }}</div>
          <button-style @click="$emit('remove', student.id)"><i class="fa fa-trash"></i> Trash</button-style>

          <button-style @click="showDialog(index)"><i class="fa fa-bars"></i> Edit</button-style>
          <create-dialog-page v-model:show="dialogVisible[index]">
            <form-edit-student :student="student"
                               :groups="groups"
                               @edit="edit"/>
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
import FormEditStudent from "@/components/Students/FormEditStudent.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Student",
  components: {ButtonStyle, TableStyle, CreateDialogPage, FormEditStudent,Title},
  data() {
    return {
      dialogVisible: [],
    }
  },
  props: {
    students: {
      type: Array,
      required: true
    },
    groups: {
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedStudent) {
      this.$emit('edit', changedStudent);
      this.dialogVisible = [];
    },
    showDialog(index) {
      this.dialogVisible[index] = true;
    },


  },
}

</script>

<style scoped>
.student {
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

.students {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}

</style>