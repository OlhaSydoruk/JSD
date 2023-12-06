<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Add News</h1>

    <input type="text" name="text" placeholder="Text"
           v-model="form.text"
    />
    <p
        v-if="validateError(v$.form.text)===1" class="error"
    >{{ this.errors["empty"] }}</p>

    <input type="text" name="fotoWay" placeholder="Foto Link"
           v-model="form.fotoWay"
    />
    <p
        v-if="validateError(v$.form.fotoWay)===1" class="error"
    >{{ this.errors["empty"] }}</p>

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
  name: "Form-news",
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
        text: {required },
        fotoWay:{required}

      }
    }
  },

  methods: {

    validateError(paramInvalid) {

      if (paramInvalid.$dirty && paramInvalid.required.$invalid) {
        return 1;//The field should not be empty
      }else {
        return 0;}
    },
    formValidation() {
      if (this.v$.$invalid) this.v$.$touch()
      else {
        this.createForm();

      }
    },
    createForm(){
      this.form.id= Math.random();
      this.$emit('createNews', this.form)
      this.form ={
        text : "",
        fotoWay : "",
      }
    }
  },
  data(){
    return {
      form: {
        text: "",
        fotoWay: "",
      },
      errors: {
        empty: "The field should not be empty",
        alpha: "There should be only letters!",
        emailIncorrect: "Email should be correct!"
      },
    }
  }
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