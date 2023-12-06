<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Edit Group</h1>
    <div class="wrapper__input">
      <v-select @click="getDepartmentsNames" id="Group" :options="nameDepartments" v-model="nameOfDepartment" placeholder="Department">
      </v-select>
      <p
          v-if="validateError(v$.nameOfDepartment)===1" class="error"
      > {{ this.errors["empty"] }}</p>
    </div>

    <input type="text" name="name" placeholder="Name"
           v-model="group.name"
    />
    <p
        v-if="validateError(v$.group.name)===1" class="error"
    >{{ this.errors["empty"] }}</p>

    <div class="wrapper__input">
      <input type="text" name="course" placeholder="course"
             v-model="group.course"
      />
      <p
          v-if="validateError(v$.group.course)===1" class="error"
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
  name: "FormEditGroup",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      nameOfDepartment:{required},
      group: {
        name: {required },
        course:{required},
      }
    }
  },
  props:{
    group: {
      type: Object,
      required: true
    },
    departments:{
      type: Array,
      required: true
    }

  },
  methods: {

    compareNameId() {
      let nameDepartment = this.nameOfDepartment;
      let department = this.departments.find(function (department) {
        if (nameDepartment === department.name) {
          return true
        }
      })
      this.group.departmentId = department.id
    },
    getDepartmentsNames() {
      for (let i in this.departments) {
        this.nameDepartments[i] = this.departments[i].name;
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
      this.$emit('editGroup', this.group)
    }
  },
  data(){
    return {
      nameOfDepartment: "",
      nameDepartments:[],
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