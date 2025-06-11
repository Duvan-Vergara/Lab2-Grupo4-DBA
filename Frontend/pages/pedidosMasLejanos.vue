<template>
  <div class="container">
    <h1 class="title text-center">Pedidos más lejanos por empresa</h1>
    
    <div class="mt-4 text-center">
      <button @click="obtenerPedidosLejanos">
        Obtener pedidos lejanos
      </button>
    </div>

    <div v-if="cargando">
      <p>Cargando datos...</p>
    </div>

    <div v-if="error">
      <p>Error: {{ error }}</p>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th>Empresa</th>
          <th>ID Pedido</th>
          <th>Distancia (km)</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="pedido in pedidos" :key="pedido.id_empresa_asociada">
          <td>{{ pedido.empresa }}</td>
          <td>{{ pedido.id_pedido }}</td>
          <td>{{ pedido.distancia.toFixed(6) }}</td>
        </tr>
      </tbody>
    </table>

  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useNuxtApp } from '#app'

const pedidos = ref([])
const cargando = ref(false)
const error = ref('')
const { $apiClient } = useNuxtApp()

const obtenerPedidosLejanos = async () => {
  pedidos.value = []
  error.value = ''
  cargando.value = true
  
  try {
    const response = await $apiClient.get('/empresaAsociada/pedido-mas-lejano')
    pedidos.value = response.data
  } catch (err) {
    error.value = 'Error al obtener los pedidos más lejanos'
    console.error(err)
  } finally {
    cargando.value = false
  }
}
</script>