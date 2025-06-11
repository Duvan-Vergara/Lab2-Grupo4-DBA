<template>
  <div class="text-center my-8">
    <h1 class="title">Verificar Zona de Cobertura</h1>
    
    <div class="mt-4">
      <input
        type="number"
        v-model.number="idCliente"
        placeholder="ID Cliente"
      />
      <button @click="verificarZona">Consultar</button>
    </div>

    <div v-if="zona">
      <h2>Resultado:</h2>
      <p>ID Zona: {{ zona.id_zona }}</p>
      <p>Nombre: {{ zona.nombre }}</p>
      <p>Tipo: {{ zona.tipo }}</p>
    </div>

    <div v-if="error">
      <p>{{ error }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useNuxtApp } from '#app'

const idCliente = ref('')
const zona = ref(null)
const error = ref('')
const { $apiClient } = useNuxtApp()

const verificarZona = async () => {
  if (!idCliente.value) {
    error.value = 'Ingrese un ID de cliente'
    return
  }

  zona.value = null
  error.value = ''
  
  try {
    const response = await $apiClient.get(`/cliente/zona-de-cliente/${idCliente.value}`)
    zona.value = response.data
  } catch (err) {
    if (err.response?.status === 403) {
      error.value = 'El cliente no tiene cobertura'
    } else {
      error.value = 'Error al consultar'
      console.error(err)
    }
  }
}
</script>