package delivery.demo.services;

import delivery.demo.repositories.ZonaCoberturaRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ZonaCoberturaService {

    @Autowired
    private ZonaCoberturaRepositoryImp zonaCoberturaRepositoryImp;

    public List<Map<String, Object>> obtenerZonasConAltaDensidad() {
        return zonaCoberturaRepositoryImp.zonasAltaDensidadDePedidos();
    }
}
