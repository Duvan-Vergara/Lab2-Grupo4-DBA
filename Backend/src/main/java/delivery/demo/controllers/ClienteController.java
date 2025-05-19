package delivery.demo.controllers;

import delivery.demo.entities.ClienteEntity;
import delivery.demo.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/con-mas-gasto")
    public ClienteEntity obtenerClienteConMasGasto() {
        return clienteService.idClienteTopGasto();
    }

    @GetMapping("/")
    public List<ClienteEntity> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @GetMapping("/correo")
    public ClienteEntity obtenerClientePorCorreo(@RequestParam String correo) {
        return clienteService.findByCorreo(correo);
    }

    @DeleteMapping("/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente) {
        clienteService.delete(id_cliente);
    }
}
