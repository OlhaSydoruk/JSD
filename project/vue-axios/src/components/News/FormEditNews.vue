<template>
  <form-style action="" class="form" id="form" @submit.prevent="formValidation">
    <h1>Edit News</h1>

    <input type="text" name="text" placeholder="text"
           v-model="news.text"
    />
    <p
        v-if="validateError(v$.news.fotoWay)===1" class="error"
    >{{ this.errors["empty"] }}</p>

    <br>

    <input type="text" name="fotoWay" placeholder="Foto Link"
           v-model="news.fotoWay"
    />
    <p
        v-if="validateError(v$.news.fotoWay)===1" class="error"
    >{{ this.errors["empty"] }}</p>

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
  name: "FormEditNews",
  components: {
    vSelect, FormStyle
  },
  directives: {
    mask
  },
  setup: () => ({v$: useVuelidate()}),
  validations() {
    return {
      news: {
        text: {required },
        fotoWay: {required },
      }
    }
  },
  props:{
    news: {
      type: Object,
      required: true
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
        this.editForm();
      }
    },
    editForm(){
      this.$emit('editNews', this.news)

    }
  },
  data(){
    return {

      errors: {
        empty: "The field should not be empty",
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