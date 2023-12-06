<template>
  <div class="main">
    <button-style @click="showDialog">Create groups</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-group
          :departments ="this.departments"
          @createGroup="insertGroup"
      />
    </create-dialog-page>
    <groups :groups="this.groups"
                 :departments ="this.departments"
                 @removeGroup="deleteGroup"
                 @editGroup="updateGroup"/>
  </div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import DepartmentService from "@/services/DepartmentService";
import FormGroup from "@/components/Groups/Form-group.vue";
import Groups from "@/components/Groups/Groups.vue";
import GroupService from "@/services/GroupService";

export default {
  name: "GroupsPage",
  components: {ButtonStyle, FormGroup, CreateDialogPage, Groups},
  data() {
    return {
      dialogVisible: false,
      group: "",
      departments: [],
      groups:[]
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateGroup(group) {
      GroupService.updateGroup(group).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getGroups();
      })
    },

    insertGroup(group) {
      GroupService.insertGroup(group).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getGroups();
      })
    },
    getGroups(){
      GroupService.getGroups().then((response)=>{
        console.log(response);
        this.groups = response.data;
      })
    },
    getDepartments() {
      DepartmentService.getDepartments().then((response) => {
        console.log(response);
        this.departments = response.data;
      })
    },
    deleteGroup(id) {
      GroupService.deleteGroup(id).then((response) => {
        console.log(response);
        this.getGroups();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getDepartments();
    this.getGroups()
  }
}

</script>

<style scoped>

</style>