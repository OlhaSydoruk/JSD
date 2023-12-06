<template>
  <div class="main">
    <button-style @click="showDialog">Create schedule</button-style>
    <create-dialog-page v-model:show="dialogVisible">
      <form-schedule
          :teachers ="this.teachers"
          :disciplines="this.disciplines"
          :groups="this.groups"
          @createSchedule="insertSchedule"
      />
    </create-dialog-page>
    <schedules :schedules="this.schedules"
               :teachers ="this.teachers"
               :disciplines="this.disciplines"
               :groups="this.groups"
                 @removeSchedule="deleteSchedule"
                 @editSchedule="updateSchedule"/>
  </div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
import CreateDialogPage from "@/components/UI/CreateDialogPage.vue";
import FormSchedule from "@/components/Schedules/Form-schedule.vue";
import Schedules from "@/components/Schedules/Schedules.vue";
import TeachersService from "@/services/TeachersService";
import DisciplineService from "@/services/DisciplineService";
import GroupService from "@/services/GroupService";
import ScheduleService from "@/services/ScheduleService";
export default {
  name: "SchedulesPage",
  components: {ButtonStyle, FormSchedule, CreateDialogPage, Schedules},
  data() {
    return {
      dialogVisible: false,
      schedule: "",
      schedules: [],
      teachers:[],
      disciplines:[],
      groups:[]
    }
  },
  methods: {
    showDialog() {
      this.dialogVisible = true
    },
    updateSchedule(schedule) {
      ScheduleService.updateSchedule(schedule).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getSchedules();
      })
    },

    insertSchedule(schedule) {
      console.log(schedule)
      ScheduleService.insertSchedule(schedule).then((response) => {
        console.log(response);
        this.dialogVisible = false;
        this.getSchedules();
      })
    },
    getSchedules(){
      ScheduleService.getSchedules().then((response)=>{
        console.log(response);
        this.schedules = response.data;
      })
    },
    getTeachers() {
      TeachersService.getTeachers().then((response) => {
        console.log(response);
        this.teachers = response.data;
      })
    },
    getDisciplines(){
      DisciplineService.getDisciplines().then((response)=>{
        console.log(response);
        this.disciplines = response.data;
      })
    },
    getGroups(){
      GroupService.getGroups().then((response)=>{
        console.log(response);
        this.groups = response.data;
      })
    },
    deleteSchedule(id) {
      ScheduleService.deleteSchedule(id).then((response) => {
        console.log(response);
        this.getSchedules();
      }).catch(error => console.log(error));
    }
  },
  created() {
    this.getSchedules();
    this.getDisciplines();
    this.getGroups();
    this.getTeachers();
  }
}
</script>

<style scoped>

</style>