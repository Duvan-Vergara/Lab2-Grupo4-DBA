<template>
  <div class="text-center my-8">
    <h1 class="title">Buscar Puntos de Interés Cercanos</h1>

    <div class="mt-4 space-y-4">
      <input
        type="number"
        v-model.number="idCliente"
        placeholder="ID Cliente"
      />
      <input
        type="number"
        v-model.number="radioKm"
        placeholder="Distancia en Km"
        step="0.1"
      />
      <button @click="consultarPuntos">Buscar</button>
    </div>

    <div v-if="resultados.length > 0" class="mt-6">
      <h2 class="font-bold">Resultados:</h2>
      <ul>
        <li v-for="punto in resultados" :key="punto.id">
          {{ punto.nombre }} - {{ punto.tipo }} ({{ punto.distancia_metros.toFixed(2) }} m)
        </li>
      </ul>
    </div>

    <div v-else-if="mensaje" class="mt-4 text-gray-600 italic">
      {{ mensaje }}
    </div>

    <div v-if="error" class="text-red-500 mt-4">
      {{ error }}
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useNuxtApp } from '#app'

const idCliente = ref('')
const radioKm = ref('')
const resultados = ref([])
const error = ref('')
const mensaje = ref('')
const { $apiClient } = useNuxtApp()

const consultarPuntos = async () => {
  if (!idCliente.value || !radioKm.value) {
    error.value = 'Ingrese el ID del cliente y la distancia en km'
    mensaje.value = ''
    resultados.value = []
    return
  }

  error.value = ''
  mensaje.value = ''
  resultados.value = []

  const radioMetros = parseFloat(radioKm.value) * 1000

  try {
    const res = await $apiClient.get('/pedido/cercanos', {
      params: {
        idCliente: idCliente.value,
        radio: radioMetros
      }
    })

    if (res.data && res.data.length > 0) {
      resultados.value = res.data
    } else {
      mensaje.value = 'No se han encontrado puntos de interés cercanos'
    }
  } catch (err) {
    error.value = 'Error al consultar puntos de interés'
    console.error(err)
  }
}
</script>
