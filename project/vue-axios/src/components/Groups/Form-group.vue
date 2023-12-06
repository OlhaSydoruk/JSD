<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Add Group</h1>
    <div class="wrapper__input">
      <v-select @click="getDepartmentsNames" id="Group" :options="nameDepartments" v-model="nameOfDepartment" placeholder="Department">
      </v-select>
      <p
          v-if="validateError(v$.nameOfDepartment)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>

    <input type="text" name="name" placeholder="Name"
           v-model="form.name"
    />
    <p
        v-if="validateError(v$.form.name)===1" class="error"
    >{{ this.errors["empty"] }}</p>

    <div class="wrapper__input">
      <input type="text" name="course" placeholder="course"
             v-model="form.course"
      />
      <p
          v-if="validateError(v$.form.course)===1" class="error"
      > {{ this.errors["empty"] }}</p>

    </div>

    <br>
    <button type="submit" class="form-button"> Add </button>
  </form-style>
</template>

<script>
import vSelect from "vue-select";
import FormStyle from "@/components/UI/Form-style.vue";
import {mask} from "vue-the-mask";
import useVuelidate from "@vuelidate/core";
import {required} from "@vuelidate/validators";

export default {
  name: "Form-group",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  props:{
    departments:{
      type: Array,
      required: true
    }
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      nameOfDepartment:{required},
      form: {
        name: {required },
        course: {required},
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
      let nameDepartment = this.nameOfDepartment;
      let department = this.departments.find(function (department) {
        if (nameDepartment === department.name) {
          return true
        }
      })
      this.form.departmentId = department.id
    },
    getDepartmentsNames() {
      for (let i in this.departments) {
        this.nameDepartments[i] = this.departments[i].name;
      }
    },
    createForm(){
      this.form.id= Math.random();
      this.$emit('createGroup', this.form)
      this.form ={
        departmentId : "",
        name : "",
        course: "",
      }
    }
  },
  data(){
    return {
      nameOfDepartment: "",
      nameDepartments:[],
      form: {
        name: "",
        course: "",
        departmentId: "",
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