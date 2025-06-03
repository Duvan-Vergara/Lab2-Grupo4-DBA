package delivery.demo.controllers;

import delivery.demo.entities.PedidoProductoEntity;
import delivery.demo.services.PedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoProducto")
@CrossOrigin


public class PedidoProductoController {

    public PedidoProductoController(PedidoProductoService pedidoProductoService) {
        this.pedidoProductoService = pedidoProductoService;
    }

    @Autowired
    private final PedidoProductoService pedidoProductoService;

    @GetMapping("/{id}")
    public List<PedidoProductoEntity> obtenerPedidoProductoPorId(@RequestParam Long id) {
        return pedidoProductoService.obtenerPedidoProductoPorId(id);
    }

}