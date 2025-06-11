<template>
  <div class="container">
    <header class="navbar">
      <div class="logo">
        <h1 class="title">Mercado Libren't</h1>
      </div>

      <nav class="nav-main">
        <!-- Inicio (sin dropdown) -->
        <nuxt-link to="/" class="nav-item" @click="closeAllDropdowns">Inicio</nuxt-link>

        <!-- Acceso -->
        <div class="nav-item dropdown" @mouseenter="openDropdown($event)" @mouseleave="closeDropdown($event)">
          <span>Acceso</span>
          <div class="dropdown-content" ref="accesoDropdown">
            <nuxt-link to="/login" @click="closeAllDropdowns">Iniciar Sesión</nuxt-link>
            <nuxt-link to="/register" @click="closeAllDropdowns">Registrarse</nuxt-link>
          </div>
        </div>

        <!-- Clientes -->
        <div class="nav-item dropdown" @mouseenter="openDropdown($event)" @mouseleave="closeDropdown($event)">
          <span>Clientes</span>
          <div class="dropdown-content" ref="clientesDropdown">
            <nuxt-link to="/cliente" @click="closeAllDropdowns">Lista Clientes</nuxt-link>
            <nuxt-link to="/clienteCobertura" @click="closeAllDropdowns">Cobertura</nuxt-link>
            <nuxt-link to="/clientesSinEmpresaCercana" @click="closeAllDropdowns">Sin Empresa Cercana</nuxt-link>
            <nuxt-link to="/clientesEnZona" @click="closeAllDropdowns">En Zona</nuxt-link>
          </div>
        </div>

        <!-- Reportes -->
        <div class="nav-item dropdown" @mouseenter="openDropdown($event)" @mouseleave="closeDropdown($event)">
          <span>Reportes</span>
          <div class="dropdown-content" ref="reportesDropdown">
            <nuxt-link to="/desempeno" @click="closeAllDropdowns">Desempeño</nuxt-link>
            <nuxt-link to="/cercanosEmpresa" @click="closeAllDropdowns">Cercanos Empresa</nuxt-link>
            <nuxt-link to="/pedidosMasLejanos" @click="closeAllDropdowns">Pedidos Lejanos</nuxt-link>
            <nuxt-link to="/zonaDensa" @click="closeAllDropdowns">Zona Densa</nuxt-link>
          </div>
        </div>
      </nav>
    </header>

    <main class="main-content">
      <nuxt-page />
    </main>
  </div>
</template>

<script>
export default {
  methods: {
    openDropdown(event) {
      const dropdown = event.currentTarget.querySelector('.dropdown-content')
      this.closeAllDropdowns()
      dropdown.style.display = 'block'
    },
    closeDropdown(event) {
      const dropdown = event.currentTarget.querySelector('.dropdown-content')
      // Pequeño retraso para permitir hacer clic en los enlaces
      setTimeout(() => {
        dropdown.style.display = 'none'
      }, 200)
    },
    closeAllDropdowns() {
      document.querySelectorAll('.dropdown-content').forEach(dropdown => {
        dropdown.style.display = 'none'
      })
    }
  }
}
</script>


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
