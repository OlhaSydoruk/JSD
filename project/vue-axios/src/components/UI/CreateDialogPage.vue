<template>
  <div class="createDialog" v-show="show" @click.stop="hideDialog">
    <div @click.stop class   ="dialog--content">
      <slot>

      </slot>

    </div>

  </div>
</template>

<script>
export default {
  name: "CreateDialogPage",
  props:{
      show:{
        type: Boolean,
        default:false
      },

  },
  methods:{
    hideDialog(){
      this.$emit('update:show', false)
    }
  }
}
</script>

<style scoped>
.createDialog{
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0,0,0, 0.5);
  position: fixed;
  display: flex;
}
.dialog--content{
  margin: auto;
  background-color:rgba(0,0,0, 0.8);
  padding: 3%;
  width: 30%;
}
</style>