<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <div class="table-container">

    <Title>Schedules List</Title>
    <div>
      <div class="schedules">
        <div v-for="(schedule, index) in schedules" v-bind:key="schedule.id" class="schedule">
          <div >Schedule ID: {{ schedule.id }}</div>
          <div >Name: {{ schedule.name }}</div>
          <div >Discipline ID: {{ schedule.disciplinesId}}</div>
          <div >Teacher ID: {{ schedule.teacherId}}</div>
          <div > Group ID: {{ schedule.groupsId}}</div>
          <div >Time: {{ schedule.time}}</div>
          <div >Classroom: {{ schedule.classroom}}</div>
          <button-style @click="$emit('removeSchedule', schedule.id)"><i class="fa fa-trash"></i> Trash</button-style>

          <button-style @click="showDialog(index)"><i class="fa fa-bars"></i> Edit</button-style>
          <create-dialog-page v-model:show="dialogVisible[index]">
            <form-edit-schedule :schedule="schedule"
                                :teachers ="teachers"
                                :disciplines="disciplines"
                                :groups="groups"
                                @editSchedule="edit"/>
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
import FormEditSchedule from "@/components/Schedules/FormEditSchedule.vue";
import Title from "@/components/UI/Title.vue";
export default {
  name: "Schedules",
  components: {ButtonStyle, TableStyle, CreateDialogPage, FormEditSchedule, Title},
  data() {
    return {
      dialogVisible: [],
    }
  },
  props: {
    schedules: {
      type: Array,
      required: true
    },
    teachers:{
      type: Array,
      required: true
    },
    disciplines:{
      type: Array,
      required: true
    },
    groups:{
      type: Array,
      required: true
    }
  },
  methods: {
    edit(changedSchedule) {
      this.$emit('editSchedule', changedSchedule);
      this.dialogVisible = [];
    },
    showDialog(index) {
      this.dialogVisible[index] = true;
    },


  },
}
</script>

<style scoped>
.schedule{
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

.schedules {

  display: flex;
  width: 100%;
  justify-content: center;
  flex-wrap: wrap;
}
</style>