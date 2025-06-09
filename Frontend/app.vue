<template>
  <div class="container">
    <header class="flex items-center justify-between p-4 border-b border-border-color">
      <div class="text-center my-8">
        <h1 class="title">Mercado Libren't</h1>
      </div>

      <nav class="flex flex-wrap gap-2">
        <nuxt-link to="/" class="btn btn-link">Inicio</nuxt-link>
        <nuxt-link to="/login" class="btn btn-link">Iniciar Sesión</nuxt-link>
        <nuxt-link to="/register" class="btn btn-link">Registrarse</nuxt-link>
        <nuxt-link to="/cliente" class="btn btn-link">Clientes</nuxt-link>
        <nuxt-link to="/desempeno" class="btn btn-link">Desempeño</nuxt-link>
        <nuxt-link to="/cercanosEmpresa" class="btn btn-link">Cercanos Empresa</nuxt-link>
        <nuxt-link to="/clienteCobertura" class="btn btn-link">Cliente Cobertura</nuxt-link>
        <nuxt-link to="/pedidosMasLejanos" class="btn btn-link">Pedidos Más Lejanos</nuxt-link>
        <nuxt-link to="/clientesSinEmpresaCercana" class="btn btn-link">Clientes Sin Empresa Cercana</nuxt-link>
        <nuxt-link to="/clientesEnZona" class="btn btn-link">Clientes en Zona</nuxt-link>
        <nuxt-link to="/zonaDensa" class="btn btn-link">Zona Densa</nuxt-link>
      </nav>
    </header>

    <main class="p-6">
      <nuxt-page />
    </main>

    <footer class="text-center p-4 border-t border-border-color">
      <button @click="logoutUser" class="btn btn-secondary mt-2">Cerrar Sesión</button>
      <p class="text-optional-color">© 2025 Mi Aplicación</p>
    </footer>
  </div>
</template>

<script setup>
import { handleLogout } from './src/services/authService'
import { useNuxtApp } from '#app'
import { useRouter } from 'vue-router'

const { $apiClient } = useNuxtApp()
const router = useRouter()

const logoutUser = async () => {
  await handleLogout($apiClient, router)
}
</script>
