<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
  <h1>Add Student</h1>
      <div class="wrapper__input">
        <v-select  @click="getGroupsNames" id="Group" :options="nameGroups" v-model="form.groupId" placeholder="Group">
        </v-select>
        <p
            v-if="validateError(v$.form.groupId)===1" class="error"
        > {{ this.errors["empty"] }}</p>
      </div>

      <input type="text" name="name" placeholder="Name"
             v-model="form.name"
      />
      <p
          v-if="validateError(v$.form.name)===1" class="error"
      >{{ this.errors["empty"] }}</p>

    <div class="wrapper__input">
      <input type="email" name="email" placeholder="email"
             v-model="form.email"
      />
      <p
          v-if="validateError(v$.form.email)===1" class="error"
      > {{ this.errors["empty"] }}</p>
      <p
          v-if="validateError(v$.form.email)===4" class="error"
      >{{ this.errors["emailIncorrect"] }}</p>
    </div>
    <div class="wrapper__input">
      <input id="phone" name="phone" type="text" data-mask="phone"
             v-model="form.phone"
             v-mask="'38(0##)###-##-##'"
             placeholder="+38(0__)___--"/>
      <p
          v-if="validateError(v$.form.phone)===1" class="error"
      > {{ this.errors["empty"] }}</p>

    </div>
    <br>
    <button type="submit" class="form-button"> Add </button>
<!--  </div>-->
  </form-style>
</template>

<script>
import vSelect from "vue-select"
import 'vue-select/dist/vue-select.css';
import {mask} from "vue-the-mask";
import useVuelidate from '@vuelidate/core'
import {email, required} from '@vuelidate/validators'
import FormStyle from "@/components/UI/Form-style.vue";
export default {
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      form: {
        groupId: {required},
        name: {required },
        phone: {required},
        email: {email, required},
      }
    }
  },
props:{
    groups:{
      type:Array,
      required: true
    }
},
  methods: {

    validateError(paramInvalid) {

      if (paramInvalid.$dirty && paramInvalid.required.$invalid) {
        return 1;//The field should not be empty
      }  else if (paramInvalid === this.v$.form.email) {
        if (paramInvalid.$dirty && paramInvalid.email.$invalid) return 4;//Email should be correct!
      }
      return 0;
    },
    formValidation() {
      if (this.v$.$invalid) this.v$.$touch()
      else {
        this.createForm();

      }
    },
    getGroupsNames() {
      for (let i in this.groups) {
        this.nameGroups[i] = this.groups[i].name;
      }
    },
    createForm(){
      this.form.id= Math.random();
      this.$emit('create', this.form)
      this.form ={
        groupId : "",
        name : "",
        phone : "",
        email : "",
      }
    }
  },
  data(){
    return {
      nameGroups:[],
      form: {
        name: "",
        phone: "",
        email: "",
        groupId: "",
      },
      errors: {
        empty: "The field should not be empty",
        alpha: "There should be only letters!",
        emailIncorrect: "Email should be correct!"
      },
    }
  },
  name: "Form-student"
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