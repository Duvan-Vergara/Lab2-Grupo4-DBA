<template>
  <div>
    <h1>Verificación de clientes en zona</h1>
    
    <div>
      <input 
        type="number" 
        v-model.number="idZona" 
        placeholder="ID de zona" 
        min="1"
      >
      <button @click="verificarClientesEnZona">Verificar</button>
    </div>

    <div v-if="cargando">
      <p>Cargando información...</p>
    </div>

    <div v-if="error">
      <p class="error">{{ error }}</p>
    </div>

    <div v-if="clientes.length > 0">
      <h2>Resultados para zona {{ idZona }}</h2>
      <p>Total clientes: {{ clientes.length }}</p>
      <p>Clientes dentro de zona: {{ clientesDentro }}</p>
      <p>Clientes fuera de zona: {{ clientesFuera }}</p>
      
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Estado</th>
          </tr>
        </thead>
        <tbody>
          <tr 
            v-for="cliente in clientes" 
            :key="cliente.id_cliente"
            :class="{ 'dentro-zona': cliente.estado === 'Dentro de la zona' }"
          >
            <td>{{ cliente.id_cliente }}</td>
            <td>{{ cliente.nombre }}</td>
            <td>{{ cliente.estado }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useNuxtApp } from '#app'

const idZona = ref('')
const clientes = ref([])
const cargando = ref(false)
const error = ref('')
const { $apiClient } = useNuxtApp()

const clientesDentro = computed(() => {
  return clientes.value.filter(c => c.estado === 'Dentro de la zona').length
})

const clientesFuera = computed(() => {
  return clientes.value.filter(c => c.estado === 'Fuera de la zona').length
})

const verificarClientesEnZona = async () => {
  if (!idZona.value) {
    error.value = 'Por favor ingrese un ID de zona válido'
    return
  }

  clientes.value = []
  error.value = ''
  cargando.value = true

  try {
    const response = await $apiClient.get(`/cliente/en-zona/${idZona.value}`)
    clientes.value = response.data
  } catch (err) {
    error.value = 'Error al verificar clientes en la zona'
    console.error(err)
  } finally {
    cargando.value = false
  }
}
</script>