<template>
<button class="button">
<slot> </slot>
</button>
</template>

<script>
export default {
  name: "Button-style"
}
</script>

<style scoped>
.button{
  width: auto;
  height: 40px;
  border: 2px solid #000000;
  background: rgb(0, 0, 0);
  text-align: center;
  color: gold;
  margin: 8px;
  padding: 3px;
  font-size: 20px;
}
.button:focus {
  outline: none;
  background: gray;
}
</style>