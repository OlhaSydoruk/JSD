<template>
<div class="navbar">
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/news')" >News</button-style >
  </div>
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/students')" >Students</button-style >
  </div>
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/disciplines')">Disciplines</button-style >
  </div>
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/faculties')">Faculties</button-style >
  </div>
  <div>
    <button-style class="submit-navbar" @click="$router.push('/groups')">Groups</button-style >
  </div>

  <div>
    <button-style class="submit-navbar" @click="$router.push('/departments')">Departments</button-style >
  </div>
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/schedules')">Schedules</button-style >
  </div>
  <div>
    <button-style  class="submit-navbar" @click="$router.push('/teachers')">Teachers</button-style >
  </div>
</div>
</template>

<script>
import ButtonStyle from "@/components/UI/Button-style.vue";
export default {
  name: "Navbar",
  components:{
    ButtonStyle,
  }
}
</script>

<style scoped>
.navbar a{
  color: yellow;
  text-decoration: none;
}
.navbar {
  display: flex;
  background: #000000;

}
.navbar div{
  text-align: center;
  color: black;
  padding: 7px;
  margin: 10px 30px;
  flex-grow:1;/* чтобы занимал всё пространство */

}
.navbar div:hover{
  background-color: rgba(46,46,46,0.9);
}
.button-navbar{

}
</style>