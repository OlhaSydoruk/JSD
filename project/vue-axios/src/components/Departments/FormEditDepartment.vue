<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Edit Department</h1>
    <div class="wrapper__input">
      <v-select @click="getFacultiesNames" id="Group" :options="nameFaculties" v-model="nameOfFaculty" placeholder="Faculty">
      </v-select>
      <p
          v-if="validateError(v$.nameOfFaculty)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>

    <input type="text" name="name" placeholder="Name"
           v-model="department.name"
    />
    <p
        v-if="validateError(v$.department.name)===1" class="error"
    >{{ this.errors["empty"] }}</p>

    <div class="wrapper__input">
      <input type="text" name="shortName" placeholder="short Name"
             v-model="department.shortName"
      />
      <p
          v-if="validateError(v$.department.shortName)===1" class="error"
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
import { required} from "@vuelidate/validators";

export default {
  name: "FormEditDepartment",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      nameOfFaculty:{required},
      department: {
        name: {required },
        shortName:{required},
      }
    }
  },
  props:{
    department: {
      type: Object,
      required: true
    },
    faculties:{
      type: Array,
      required: true
    }

  },
  methods: {

    compareNameId() {
      let nameFaculty = this.nameOfFaculty;
      let faculty = this.faculties.find(function (faculty) {
        if (nameFaculty === faculty.name) {
          return true
        }
      })
      this.department.facultyId = faculty.id
    },
    getFacultiesNames() {
      for (let i in this.faculties) {
        this.nameFaculties[i] = this.faculties[i].name;
      }
    },
    validateError(paramInvalid) {

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
    editForm(){
      this.$emit('editDepartment', this.department)
    }
  },
  data(){
    return {
      nameOfFaculty: "",
      nameFaculties:[],
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
  height: 48px;
  border: none;
  border-bottom: 1px solid #fff; /*линия снизу */
  font-family: 'Caveat', sans-serif;
  outline: none;
  text-align: center;
  background-color:rgba(0,0,0, 0);
  transition: .5s;
  color: navajowhite;
}

input::placeholder{
  color: navajowhite;
}
.wrapper__input input, button {
  width: 100%;
  height: 60px;
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