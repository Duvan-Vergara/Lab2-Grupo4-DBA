<template>
  <div class="text-center my-8">
    <h1 class="title">Zonas de alta densidad</h1>
    
    <button @click="obtenerZonasAltaDensidad" class="mt-4">Obtener zonas de alta densidad</button>

    <div v-if="cargando">
      <p>Cargando datos...</p>
    </div>

    <div v-if="error">
      <p>Error: {{ error }}</p>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th>ID Zona</th>
          <th>Nombre</th>
          <th>Pedidos en buffer</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="zona in zonas" :key="zona.id_zona">
          <td>{{ zona.id_zona }}</td>
          <td>{{ zona.nombre }}</td>
          <td>{{ zona.pedidos_en_buffer }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useNuxtApp } from '#app'

const zonas = ref([])
const cargando = ref(false)
const error = ref('')
const { $apiClient } = useNuxtApp()

const obtenerZonasAltaDensidad = async () => {
  zonas.value = []
  error.value = ''
  cargando.value = true
  
  try {
    const response = await $apiClient.get('/zonaCobertura/alta-densidad')
    zonas.value = response.data
  } catch (err) {
    error.value = 'Error al obtener las zonas de alta densidad'
    console.error(err)
  } finally {
    cargando.value = false
  }
}
</script>