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
        SELECT id_cliente, nombre, direccion, correo, password, ST_AsText(ubicacion_cliente) AS ubicacion_wkt
        FROM CLIENTE
        WHERE correo = :correo
    """;
        try (Connection con = sql2o.open()) {
            var row = con.createQuery(sql)
                    .addParameter("correo", correo)
                    .executeAndFetchTable()
                    .asList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (row == null) return Optional.empty();

            ClienteEntity cliente = new ClienteEntity();
            cliente.setId_cliente(((Number) row.get("id_cliente")).longValue());
            cliente.setNombre((String) row.get("nombre"));
            cliente.setDireccion((String) row.get("direccion"));
            cliente.setCorreo((String) row.get("correo"));
            cliente.setPassword((String) row.get("password"));

            // Convertir WKT a Point
            String wkt = (String) row.get("ubicacion_wkt");
            if (wkt != null) {
                org.locationtech.jts.io.WKTReader reader = new org.locationtech.jts.io.WKTReader();
                cliente.setUbicacion_cliente((org.locationtech.jts.geom.Point) reader.read(wkt));
            }

            return Optional.of(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    public List<Map<String, Object>> findAllClientes() {
        String sql = """
        SELECT * FROM CLIENTE
    """;

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
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
                    .addParameter("ubicacion", wkt)
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

    //Consulta 2
    @Override
    public List<Map<String, Object>> verificarClientesEnZona(Long idZona) {
        String sql = """
        SELECT
            c.id_cliente,
            c.nombre,
            CASE
                WHEN ST_Within(c.ubicacion_cliente, z.zona_geom) THEN 'Dentro de la zona'
                ELSE 'Fuera de la zona'
            END AS estado
        FROM cliente c
        JOIN zona_cobertura z ON z.id_zona = :idZona
    """;

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idZona", idZona)
                    .executeAndFetchTable()
                    .asList();
        }
    }

    //extra 1
    public Map<String, Object> findZonaDeCliente(Long idCliente) {
        String sql = """
            SELECT z.id_zona, z.nombre, z.tipo
            FROM ZONA_COBERTURA z
            JOIN CLIENTE c ON c.id_cliente = :idCliente
            WHERE ST_Within(c.ubicacion_cliente, z.zona_geom)
        """;

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idCliente", idCliente)
                    .executeAndFetchTable()
                    .asList()
                    .stream()
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}