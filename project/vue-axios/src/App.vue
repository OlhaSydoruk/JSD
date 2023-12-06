<script>
import Students from "@/pages/StudentsPage.vue";
import Navbar from "@/components/UI/Navbar.vue";
import Footer from "@/components/UI/Footer.vue";
export default {
  name: "App",
  components: {
    Students, Navbar, Footer
  }
}
</script>

<template>
  <div class="app">
    <div class="logotip">
      <img src="src/assets/images/logotip.jpg">
    </div>
    <navbar/>
    <router-view/>
    <Footer/>
  </div>

</template>

<style>

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.app{
}
.logotip {
  width: 100%;
  height: 10%;
  background: black;
}
.logotip img{
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 9%;
  height: 9%;
}

</style>
