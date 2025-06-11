<!-- filepath: e:\Universidad\BBDDA\Lab_1\Lab1-Grupo4-DBA\Frontend\pages\index.vue -->
<template>
    <div>

      <!-- Titulo de bienvenido centrado -->
      <div class="text-center my-8">
        <h1 class="title">Bienvenido a la aplicación de delivery</h1>
      </div>
    </div>
  </template>

<script setup>
definePageMeta({
    middleware: 'auth'
  })
</script>