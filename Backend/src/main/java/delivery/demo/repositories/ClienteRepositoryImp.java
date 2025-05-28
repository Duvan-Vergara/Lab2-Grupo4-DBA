package delivery.demo.repositories;

import delivery.demo.entities.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ClienteRepositoryImp implements ClienteRepository {

    @Autowired
    private final Sql2o sql2o;

    public ClienteRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public ClienteEntity obtenerClienteConMasGasto() {
        String sql = """
                    SELECT 
                      c.id_cliente,
                      c.nombre,
                      c.direccion,
                      c.correo,
                      c.password
                    FROM CLIENTE c
                    JOIN PEDIDO p ON c.id_cliente = p.id_cliente
                    JOIN DETALLE_PEDIDO dp ON p.id_detalle_pedido = dp.id_detalle_pedido
                    JOIN PEDIDO_PRODUCTO pp ON p.id_pedido = pp.id_pedido
                    JOIN PRODUCTO_SERVICIO ps ON pp.id_producto_servicio = ps.id_producto_servicio
                    WHERE dp.entregado = TRUE
                    AND c.deleted_at   IS NULL
                    AND p.deleted_at   IS NULL
                    AND dp.deleted_at  IS NULL
                    AND pp.deleted_at  IS NULL
                    AND ps.deleted_at  IS NULL
                    GROUP BY c.id_cliente, c.nombre, c.direccion, c.correo, c.password
                    ORDER BY SUM(ps.precio * pp.cantidad) DESC
                    LIMIT 1
                """;
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList()
                    .stream()
                    .findFirst()
                    .map(row -> {
                        ClienteEntity c = new ClienteEntity();
                        c.setId_cliente(((Number) row.get("id_cliente")).longValue());
                        c.setNombre((String) row.get("nombre"));
                        c.setDireccion((String) row.get("direccion"));
                        c.setCorreo((String) row.get("correo"));
                        c.setPassword((String) row.get("password"));
                        return c;
                    })
                    .orElse(null);
        }
    }

    @Override
    public Map<String, Object> findClienteQueMasGasto() {
        String sql = """
                    SELECT 
                        c.id_cliente AS "idCliente",
                        c.direccion AS "direccion",
                        c.correo AS "correo",
                        SUM(ps.precio * pp.cantidad) AS "totalGastado"
                    FROM CLIENTE c
                    JOIN PEDIDO p ON c.id_cliente = p.id_cliente
                    JOIN DETALLE_PEDIDO dp ON p.id_detalle_pedido = dp.id_detalle_pedido
                    JOIN PEDIDO_PRODUCTO pp ON p.id_pedido = pp.id_pedido
                    JOIN PRODUCTO_SERVICIO ps ON pp.id_producto_servicio = ps.id_producto_servicio
                    WHERE dp.entregado = TRUE
                    AND c.deleted_at   IS NULL
                   AND p.deleted_at   IS NULL
                   AND dp.deleted_at  IS NULL
                   AND pp.deleted_at  IS NULL
                   AND ps.deleted_at  IS NULL
                    GROUP BY c.id_cliente, c.direccion, c.correo
                    ORDER BY totalGastado DESC
                    LIMIT 1
                """;

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList()
                    .stream()
                    .findFirst()
                    .orElse(null);
        }
    }

    @Override
    public Optional<ClienteEntity> findByCorreo(String correo) {
        String sql = """
                SELECT * FROM CLIENTE 
                WHERE correo = :correo
                """;

        try (Connection con = sql2o.open()) {
            ClienteEntity cliente = con.createQuery(sql)
                    .addParameter("correo", correo)
                    .executeAndFetchFirst(ClienteEntity.class);
            return Optional.ofNullable(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<ClienteEntity> findAllClientes() {
        String sql = """
                SELECT * FROM CLIENTE
                WHERE deleted_at IS NULL
                """;

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(ClienteEntity.class);
        }
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        String sql = """
        INSERT INTO CLIENTE (nombre, direccion, correo, password, ubicacion_cliente)
        VALUES (:nombre, :direccion, :correo, :password, ST_SetSRID(ST_GeomFromText(:ubicacion), 4326))
        RETURNING id_cliente
    """;

        // Convertir Point a WKT
        String wkt = String.format("POINT(%s %s)",
                cliente.getUbicacion_cliente().getX(), // Longitud
                cliente.getUbicacion_cliente().getY()  // Latitud
        );

        try (Connection con = sql2o.open()) {
            Long id = con.createQuery(sql)
                    .addParameter("nombre", cliente.getNombre())
                    .addParameter("direccion", cliente.getDireccion())
                    .addParameter("correo", cliente.getCorreo())
                    .addParameter("password", cliente.getPassword())
                    .addParameter("ubicacion", wkt) // Ahora pasas el WKT como string
                    .executeUpdate()
                    .getKey(Long.class);

            cliente.setId_cliente(id);
            return cliente;
        }
    }

    @Override
    public void delete(Long id) {
        String sql = """
                    UPDATE CLIENTE
                    SET deleted_at = NOW()
                    WHERE id_cliente = :id
                """;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}