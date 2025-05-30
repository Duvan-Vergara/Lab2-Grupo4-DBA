<template>
  <div>
    <header>
      <h1>Mi Aplicación</h1>
      <nav>
        <nuxt-link to="/" class="btn btn-link">Inicio</nuxt-link>
        <nuxt-link to="/login" class="btn btn-link">Iniciar Sesión</nuxt-link>
        <nuxt-link to="/register" class="btn btn-link">Registrarse</nuxt-link>
        <nuxt-link to="/cliente" class="btn btn-link">Clientes</nuxt-link>
        <nuxt-link to="/desempeno" class="btn btn-link">Desempeño</nuxt-link>
        <nuxt-link to="/cercanosEmpresa" class="btn btn-link">CercanosEmpresa</nuxt-link>
        <nuxt-link to="/clienteCobertura" class="btn btn-link">Cliente Cobertura</nuxt-link>
        <nuxt-link to="/pedidosMasLejanos" class="btn btn-link">Pedidos Más Lejanos</nuxt-link>
        <nuxt-link to="/clientesSinEmpresaCercana" class="btn btn-link">Clientes Sin Empresa Cercana</nuxt-link>
        <nuxt-link to="/clientesEnZona" class="btn btn-link">Clientes en Zona</nuxt-link>
        <nuxt-link to="/zonaDensa" class="btn btn-link">Zona Densa</nuxt-link>
      </nav>
    </header>
    <main>
      <nuxt-page />
    </main>
    <footer>
      <p>© 2025 Mi Aplicación</p>
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