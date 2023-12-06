<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">

    <Title>Faculties List</Title>
    <div>
      <div class="faculties">
        <div v-for="(faculty, index) in faculties" v-bind:key="faculty.id" class="faculty">
          <div >Faculty ID: {{ faculty.id }}</div>
          <div >Name: {{ faculty.name}}</div>
          <div >Short Name: {{ faculty.shortName}}</div>
          <button-style @click="$emit('removeFaculty', faculty.id)"><i class="fa fa-trash"></i> Trash</button-style>

                    <button-style  @click="showDialog(index)" ><i class="fa fa-bars"></i> Edit </button-style>
                    <create-dialog-page v-model:show="dialogVisible[index]">
                      <form-edit-faculty :faculty="faculty"
                                         @editFaculty="edit"/>
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
import FormEditFaculty from "@/components/Faculties/FormEditFaculty.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Faculties",
  components:{ButtonStyle, TableStyle, CreateDialogPage, FormEditFaculty,Title},
  data() {
    return {
      dialogVisible:[],
    }
  },
  props: {
    faculties: {
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedFaculty){
      this.$emit('editFaculty', changedFaculty);
      this.dialogVisible = [];
    },
    showDialog(index){
      this.dialogVisible[index] = true;
    },


  },
}
</script>

<style scoped>
.faculty{
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

.faculties {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}

</style>