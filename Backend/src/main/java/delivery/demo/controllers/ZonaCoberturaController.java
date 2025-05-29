package delivery.demo.controllers;

import delivery.demo.services.ZonaCoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zonaCobertura")
@CrossOrigin

public class ZonaCoberturaController {

    @Autowired
    ZonaCoberturaService zonaCoberturaService;

    @GetMapping("/alta-densidad")
    public List<Map<String, Object>> obtenerZonasConAltaDensidad() {
        return zonaCoberturaService.obtenerZonasConAltaDensidad();
    }
}
