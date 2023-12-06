<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Edit Department</h1>
    <div class="wrapper__input">
      <input type="text" name="name" placeholder="Name"
             v-model="schedule.name"
      />
      <p
          v-if="validateError(v$.schedule.name)===1" class="error"
      >{{ this.errors["empty"] }}</p>

      <v-select @click="getDisciplinesNames" id="Group" :options="nameDisciplines" v-model="nameOfDiscipline"
                placeholder="Discipline">
      </v-select>
      <p
          v-if="validateError(v$.nameOfDiscipline)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>

    <div class="wrapper__input">
      <v-select @click="getGroupsNames" id="Group" :options="nameGroups" v-model="schedule.groupsId"
                placeholder="Group">
      </v-select>
      <p
          v-if="validateError(v$.schedule.groupsId)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>

    <div class="wrapper__input">
      <v-select @click="getTeachersNames" id="Group" :options="nameTeachers" v-model="schedule.teacherId"
                placeholder="Teacher">
      </v-select>
      <p
          v-if="validateError(v$.schedule.teacherId)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>


    <div class="wrapper__input">
      <input type="text" name="time" placeholder="Time"
             v-model="schedule.time"
      />
      <p
          v-if="validateError(v$.schedule.time)===1" class="error"
      > {{ this.errors["empty"] }}</p>

    </div>

    <div class="wrapper__input">
      <input type="text" name="classroom" placeholder="Classroom"
             v-model="schedule.classroom"
      />
      <p
          v-if="validateError(v$.schedule.classroom)===1" class="error"
      > {{ this.errors["empty"] }}</p>

    </div>

    <br>
    <button type="submit" class="form-button"> Edit</button>
  </form-style>
</template>

<script>
import vSelect from "vue-select";
import FormStyle from "@/components/UI/Form-style.vue";
import {mask} from "vue-the-mask";
import useVuelidate from "@vuelidate/core";
import {required} from "@vuelidate/validators";

export default {
  name: "FormEditSchedule",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      nameOfDiscipline: {required},
      schedule: {
        teacherId: {required},
        groupsId: {required},
        name: {required},
        time: {required},
        classroom: {required},
      }
    }
  },
  props: {
    schedule: {
      type: Object,
      required: true
    },
    teachers: {
      type: Array,
      required: true
    },
    disciplines: {
      type: Array,
      required: true
    },
    groups: {
      type: Array,
      required: true
    }

  },
  methods: {

    compareNameId() {
      let nameDiscipline = this.nameOfDiscipline;
      let discipline = this.disciplines.find(function (discipline) {
        if (nameDiscipline === discipline.name) {
          return true
        }
      })
      this.schedule.disciplinesId = discipline.id
    },
    getTeachersNames() {
      for (let i in this.teachers) {
        this.nameTeachers[i] = this.teachers[i].name;
      }
    },
    getGroupsNames() {
      for (let i in this.groups) {
        this.nameGroups[i] = this.groups[i].name;
      }
    },
    getDisciplinesNames() {
      for (let i in this.disciplines) {
        this.nameDisciplines[i] = this.disciplines[i].name;
      }
    },
    validateError(paramInvalid) {
      console.log(paramInvalid)
      if (paramInvalid.$dirty && paramInvalid.required.$invalid) {
        return 1;//The field should not be empty
      }
      return 0;
    },
    formValidation() {
      if (this.v$.$invalid) this.v$.$touch()
      else {
        this.compareNameId()
        this.editForm();
      }
    },
    editForm() {
      this.$emit('editSchedule', this.schedule)
    }
  },
  data() {
    return {
      nameOfDiscipline: "",
      groupsId: "",
      teacherId: "",
      nameDisciplines: [],
      nameGroups: [],
      nameTeachers: [],
      errors: {
        empty: "The field should not be empty",
        emailIncorrect: "Email should be correct!"
      },
    }
  },
}
</script>

<style scoped>

.error {
  color: red;
}

.form-registration h1 {
  text-align: center;
  font-size: 45px;
  font-weight: 900;
  text-shadow: -1px -2px #dcb109, 0 1px 0 #f5de4b;
  font-family: 'Caveat', sans-serif;
  margin: 0 0 30px;
  padding: 0;
}
h1{
  color: navajowhite;
}
input, v-select {
  color: navajowhite;
}


#Group  {
  width: 100%;
  height: 60px;
  border: none;
  border-bottom: 1px solid #fff; /*линия снизу */
  font-family: 'Caveat', sans-serif;
  outline: none;
  text-align: center;
  background-color:rgba(0,0,0, 0);
  transition: .5s;
  color: navajowhite;
  padding: 0 0 10px 0;
}

input::placeholder{
  color: navajowhite;
}
.wrapper__input input, button {
  width: 100%;
  height: 48px;
  border: none;
  border-bottom: 1px solid #fff; /*линия снизу */
  font-family: 'Caveat', sans-serif;
  outline: none;
  text-align: center;
}


.wrapper__input input, select, button:focus {
  outline: none;
  background-color:rgba(0,0,0, 0);
  transition: .5s;
}
.form-button{
  width: 100%;
  height: 48px;
  border: none;
  text-align: center;
  color: navajowhite;
  background-color:rgba(0,0,0, 0.2);
}
</style>