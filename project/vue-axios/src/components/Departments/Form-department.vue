<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Add Department</h1>
    <br>
    <div class="wrapper__input">

      <v-select @click="getFacultiesNames" id="Group" :options="nameFaculties" v-model="nameOfFaculty" placeholder="Faculty">
      </v-select>
      <p
          v-if="validateError(v$.nameOfFaculty)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>


<div class="wrapper__input">
<br>
    <input type="text" name="name" placeholder="Name"
           v-model="form.name"
    />
    <p
        v-if="validateError(v$.form.name)===1" class="error"
    >{{ this.errors["empty"] }}</p>
    </div>
    <br>
    <div class="wrapper__input">
      <input type="text" name="shortName" placeholder="short name"
             v-model="form.shortName"
      />
      <p
          v-if="validateError(v$.form.shortName)===1" class="error"
      > {{ this.errors["empty"] }}</p>

    </div>

    <br>
    <button type="submit" class="form-button"> Registration</button>
  </form-style>
</template>

<script>
import vSelect from "vue-select";
import FormStyle from "@/components/UI/Form-style.vue";
import {mask} from "vue-the-mask";
import useVuelidate from "@vuelidate/core";
import {email, required} from "@vuelidate/validators";

export default {
  name: "Form-department",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  props:{
    faculties:{
      type: Array,
      required: true
    }
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      nameOfFaculty:{required},
      form: {
        name: {required },
        shortName: {required},
      }
    }
  },

  methods: {

    validateError(paramInvalid) {

      if (paramInvalid.$dirty && paramInvalid.required.$invalid) {
        return 1;//The field should not be empty
      }
      return 0;
    },
    formValidation() {
      if (this.v$.$invalid) this.v$.$touch()
      else {
        this.compareNameId();
        this.createForm();

      }
    },
    compareNameId() {
      let nameFaculty = this.nameOfFaculty;
      let faculty = this.faculties.find(function (faculty) {
        if (nameFaculty === faculty.name) {
          return true
        }
      })
      this.form.facultyId = faculty.id
    },
    getFacultiesNames() {
      for (let i in this.faculties) {
        this.nameFaculties[i] = this.faculties[i].name;
      }
    },
    createForm(){
      this.form.id= Math.random();
      this.$emit('createDepartment', this.form)
      this.form ={
        facultyId : "",
        name : "",
        shortName: "",
      }
    }
  },
  data(){
    return {
      nameOfFaculty: "",
      nameFaculties:[],
      form: {
        name: "",
        shortName: "",
        facultyId: "",
      },
      errors: {
        empty: "The field should not be empty",
        alpha: "There should be only letters!",
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
  height: 50px;
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