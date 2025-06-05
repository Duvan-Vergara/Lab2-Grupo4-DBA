package delivery.demo.controllers;

import delivery.demo.entities.ClienteEntity;
import delivery.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/con-mas-gasto")
    public ClienteEntity obtenerClienteConMasGasto() {
        return clienteService.idClienteTopGasto();
    }

    @GetMapping("/")
    public List<Map<String, Object>> obtenerClientes() {
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

    @GetMapping("/en-zona/{idZona}")
    public ResponseEntity<List<Map<String, Object>>> verificarClientesEnZona(@PathVariable Long idZona) {
        return ResponseEntity.ok(clienteService.verificarClientesEnZona(idZona));
    }

    @GetMapping("/zona-de-cliente/{idCliente}")
    public ResponseEntity<Map<String, Object>> obtenerZonaDeCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(clienteService.obtenerZonaDeCliente(idCliente));
    }

}
