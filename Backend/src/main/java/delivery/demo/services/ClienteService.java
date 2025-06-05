package delivery.demo.services;

import delivery.demo.entities.ClienteEntity;
import delivery.demo.repositories.ClienteRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import delivery.demo.repositories.ClienteRepository;

import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteRepositoryImp clienteRepositoryImp;

    public Map<String, Object> obtenerClienteConMasGasto() {
        return clienteRepository.findClienteQueMasGasto();
    }


    public List<Map<String, Object>> obtenerClientes() {
        return clienteRepositoryImp.findAllClientes();
    }


    public ClienteEntity idClienteTopGasto() {
        return clienteRepository.obtenerClienteConMasGasto();
    }

    public ClienteEntity findByCorreo(String correo) {
        return clienteRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cliente con ese correo"));
    }

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(id);
    }

    public List<Map<String, Object>> verificarClientesEnZona(Long idZona) {
        return clienteRepository.verificarClientesEnZona(idZona);
    }

    public Map<String, Object> obtenerZonaDeCliente(Long idCliente) {
        Map<String, Object> zona = clienteRepository.findZonaDeCliente(idCliente);
        if (zona == null) {
            throw new RuntimeException("El cliente no pertenece a ninguna zona de cobertura");
        }
        return zona;
    }
}