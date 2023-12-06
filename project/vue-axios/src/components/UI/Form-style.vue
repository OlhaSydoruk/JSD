<template>
  <form class="form">
    <div class="wrapper">
      <div class="wrapper__input">
    <slot></slot>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: "Form-style"
}
</script>

<style scoped>

.wrapper__input input, button {
  width: 100%;
  height: 48px;
  border: 2px solid black;
  background: rgba(54, 38, 167, 0.32);
  border-radius: 8px;
  text-align: center;
  color: gold;
  font-size: 24px;
}
#Group {
  width: 100%;
  height: 48px;
  border: 2px solid #3626a7;
  background: rgba(54, 38, 167, 0.32);
  border-radius: 8px;
  text-align: center;
  color: #98EABA;
  font-size: 24px;
}
.wrapper__input input, select, button:focus {
  outline: none;
  background: rgba(54, 38, 167, 0.64);
}
</style>