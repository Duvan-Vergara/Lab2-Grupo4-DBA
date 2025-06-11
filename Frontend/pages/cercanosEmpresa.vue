<template>
    <div class="container">
        <h1 class="title text-center">Lista de los 5 puntos más cercanos a una empresa</h1>
    
        <div class="search mt-4 text-center">
            <input
                type="text"
                v-model="idEmpresa"
                placeholder="id"
                class="input"
            />
            <button @click="buscarPuntosPorEmpresa">Buscar</button>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>id_pedido</th>
                    <th>distancia_metros</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr v-for="punto in puntos" :key="punto.id_pedido">
                    <td>{{ punto.id_pedido}}</td>
                    <td>{{ punto.distancia_metros }}</td>
                </tr>
            </tbody>
        </table>

    </div>
</template>


<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useNuxtApp } from '#app'
import API_ROUTES from '../src/api-routes.js'
import { handleLogout } from '../src/services/authService.ts'

const puntos = ref([])
const idEmpresa = ref('')
const router = useRouter()
const { $apiClient } = useNuxtApp()

const buscarPuntosPorEmpresa = async () => {
    if (!idEmpresa.value) {
        alert('Por favor ingresa un id para buscar.')
        return
    }
    try {
        const empresaId = Number(idEmpresa.value)
        const response = await $apiClient.get(
            `${API_ROUTES.CERCANOS}/${empresaId}`
        )

        puntos.value = response.data

    } catch (error) {
        console.error('Error:', error)
        puntos.value = []
    }
}
</script>