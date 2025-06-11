<template>
  <div class="text-center my-8">
    <h1 class="title">Clientes sin empresa cercana</h1>
    
    <button @click="obtenerClientesSinCobertura" class="mt-4">Obtener clientes</button>

    <div v-if="cargando">
      <p>Cargando datos...</p>
    </div>

    <div v-if="error">
      <p>Error: {{ error }}</p>
    </div>

    <div v-if="clientes.length > 0" class="mx-auto">
      <h2>Clientes encontrados: {{ clientes.length }}</h2>
      <ul>
        <li v-for="cliente in clientes" :key="cliente.id_cliente">
          ID: {{ cliente.id_cliente }} - {{ cliente.nombre }}
        </li>
      </ul>
    </div>
    <div v-else-if="!cargando && consultado">
      <p>No se encontraron clientes sin cobertura</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useNuxtApp } from '#app'

const clientes = ref([])
const cargando = ref(false)
const error = ref('')
const consultado = ref(false)
const { $apiClient } = useNuxtApp()

const obtenerClientesSinCobertura = async () => {
  clientes.value = []
  error.value = ''
  cargando.value = true
  consultado.value = true
  
  try {
    const response = await $apiClient.get('/empresaAsociada/clientes-sin-empresa-cercana')
    clientes.value = response.data
  } catch (err) {
    error.value = 'Error al obtener los clientes sin cobertura'
    console.error(err)
  } finally {
    cargando.value = false
  }
}
</script>