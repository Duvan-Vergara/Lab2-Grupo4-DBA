<template>
    <div class="container">
        <form @submit.prevent="handleRegister" class="form-register">
            <h1 class="h3 mb-3 fw-normal text-center">Registro</h1>
            <div class="form-floating mb-3">
                <input v-model="nombre" type="text" class="form-control" id="floatingnombre" placeholder="nombre" required />
                <label for="floatingnombre">Nombre</label>
            </div>
            <div class="form-floating mb-3">
                <input v-model="direccion" type="text" class="form-control" id="floatingDireccion" placeholder="Dirección" required= />
                <label for="floatingDireccion">Dirección</label>
            </div>
            <div class="form-floating mb-3">
                <input v-model="correo" type="correo" class="form-control" id="floatingcorreo" placeholder="Correo Electrónico" required />
                <label for="floatingcorreo">Correo Electrónico</label>
            </div>
            <div class="form-floating mb-3">
                <input v-model="password" type="password" class="form-control" id="floatingPassword" placeholder="Contraseña" required />
                <label for="floatingPassword">Contraseña</label>
            </div>
            <div class="form-floating mb-3">
                <input v-model="latitude" type="text" class="form-control" id="floatingLatitude" placeholder="Latitud" required />
                <label for="floatingLatitude">Latitud</label>
            </div>
            <div class="form-floating mb-3">
                <input v-model="longitude" type="text" class="form-control" id="floatingLongitude" placeholder="Longitud" required />
                <label for="floatingLongitude">Longitud</label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Registrar</button>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useNuxtApp } from '#app'
import API_ROUTES from '../src/api-routes'

const nombre = ref('')
const direccion = ref('')
const correo = ref('')
const password = ref('')
const latitude = ref('')
const longitude = ref('')
const router = useRouter()
const { $apiClient } = useNuxtApp()

const handleRegister = async () => {
    try {
        const response = await $apiClient.post(API_ROUTES.REGISTER, {
            nombre: nombre.value,
            direccion: direccion.value,
            correo: correo.value,
            password: password.value,
            latitude: latitude.value,
            longitude: longitude.value
        })
        alert('Registro exitoso, ahora puedes iniciar sesión')
        router.push('/login') // Redirigir al login
    } catch (error) {
        console.error('Error al registrar:', error)
        alert(error.response?.data?.message || 'Error al registrar')
    }
}
</script>

<style scoped>
.container {
    max-width: 400px;
    margin: auto;
}
</style>