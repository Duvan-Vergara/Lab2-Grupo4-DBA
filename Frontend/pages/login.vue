<template>
    <div class="container">
        <form @submit.prevent="handleLogin">
            <h1 class="h3 mb-3 fw-normal">Iniciar Sesión</h1>
            <div class="form-floating">
                <input v-model="correo" type="correo" class="form-control" id="floatingInput"
                    placeholder="name@example.com" required>
                <label for="floatingInput">Correo Electrónico</label>
            </div>
            <div class="form-floating">
                <input v-model="password" type="password" class="form-control" id="floatingPassword"
                    placeholder="Password" required>
                <label for="floatingPassword">Contraseña</label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Iniciar Sesión</button>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useNuxtApp } from '#app'
import API_ROUTES from '../src/api-routes.js'
import { handleLogout } from '../src/services/authService.ts'

const correo = ref('')
const password = ref('')
const router = useRouter()
const { $apiClient } = useNuxtApp()

const handleLogin = async () => {
    try {
        const response = await $apiClient.post(API_ROUTES.LOGIN, {
            correo: correo.value,
            password: password.value
        })

        const access_token = response.data.access_token // Obtener el token de la respuesta

        console.log('Access Token:', access_token)

        if (!access_token) {
            alert('Error: Token no recibido')
            return
        }
        localStorage.setItem('access_token', access_token)
        router.push('/') // Redirigir a la página principal
    } catch (error) {
        console.error('Error:', error)
        alert(error.response?.data?.message || 'Error al iniciar sesión')
    }
}
</script>