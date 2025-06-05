package delivery.demo.repositories;

import delivery.demo.entities.ClienteEntity;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClienteRepository {

    ClienteEntity obtenerClienteConMasGasto();

    Map<String, Object> findClienteQueMasGasto();

    Optional<ClienteEntity> findByCorreo(String correo);


    ClienteEntity save(ClienteEntity cliente);

    void delete(Long id);

    List<Map<String, Object>> verificarClientesEnZona(Long idZona);

    Map<String, Object> findZonaDeCliente(Long idCliente);
}
