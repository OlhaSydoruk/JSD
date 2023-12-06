<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">

    <Title>Groups List</Title>
    <div>
      <div class="groups">
        <div v-for="(group, index) in groups" v-bind:key="group.id" class="group">
          <div >Group ID: {{ group.id }}</div>
          <div >Department ID: {{ group.departmentId}}</div>
          <div >Name: {{ group.name}}</div>
          <div >Course: {{ group.course}}</div>
          <button-style @click="$emit('removeGroup', group.id)"><i class="fa fa-trash"></i> Trash</button-style>

          <button-style @click="showDialog(index)"><i class="fa fa-bars"></i> Edit</button-style>
          <create-dialog-page v-model:show="dialogVisible[index]">
            <form-edit-group :group="group"
                             :departments="departments"
                             @editGroup="edit"/>
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
import FormEditGroup from "@/components/Groups/FormEditGroup.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Groups",
  components: {ButtonStyle, TableStyle, CreateDialogPage, FormEditGroup,Title},
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
    groups:{
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedGroup) {
      this.$emit('editDepartment', changedGroup);
      this.dialogVisible = [];
    },
    showDialog(index) {
      this.dialogVisible[index] = true;
    },


  },
}
</script>

<style scoped>
.group{
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

.groups {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}

</style>