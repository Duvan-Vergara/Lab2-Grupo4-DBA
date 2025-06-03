package delivery.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import delivery.demo.services.EmpresaAsociadaService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empresaAsociada")
@CrossOrigin
public class EmpresaAsociadaController {

    public EmpresaAsociadaController(EmpresaAsociadaService empresaAsociadaService) {
        this.empresaAsociadaService = empresaAsociadaService;
    }

    @Autowired
    private final EmpresaAsociadaService empresaAsociadaService;

    @GetMapping("/entregas-fallidas")
    public List<Map<String, Object>> obtenerEntregasFallidasPorEmpresa(){
        return empresaAsociadaService.obtenerEntregasFallidasPorEmpresa();
    }
    @GetMapping("/top-volumen")
    public List<Map<String, Object>> obtenerEmpresasConMasEntregas() {
        return empresaAsociadaService.obtenerEntregasExitosasPorEmpresa();
    }

    @GetMapping("/pedido-mas-lejano")
    public ResponseEntity<List<Map<String, Object>>> obtenerPedidoMasLejano() {
        return ResponseEntity.ok(empresaAsociadaService.obtenerPedidoMasLejanoPorEmpresa());
    }

    @GetMapping("/clientes-sin-empresa-cercana")
    public List<Map<String, Object>> obtenerClientesSinEmpresaCercana() {
        return empresaAsociadaService.obtenerClientesSinEmpresaCercana();
    }

}
