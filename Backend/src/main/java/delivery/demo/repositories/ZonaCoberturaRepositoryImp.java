package delivery.demo.repositories;

import org.sql2o.Sql2o;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ZonaCoberturaRepositoryImp {

    private final Sql2o sql2o;
    public ZonaCoberturaRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Map<String, Object>> zonasAltaDensidadDePedidos() {
        String sql = """
            WITH zona_pedidos AS (
              SELECT\s
                z.id_zona,
                z.nombre,
                ST_Collect(p.ubicacion_entrega) AS pedidos_agrupados
              FROM ZONA_COBERTURA z
              JOIN PEDIDO p ON ST_Within(p.ubicacion_entrega, z.zona_geom)
              GROUP BY z.id_zona, z.nombre
            )
            SELECT\s
              zp.id_zona,
              zp.nombre,
              COUNT(p.id_pedido) AS pedidos_en_buffer
            FROM zona_pedidos zp
            JOIN PEDIDO p ON ST_Intersects(
                ST_Buffer(zp.pedidos_agrupados::geography, 500)::geometry,
                p.ubicacion_entrega
              )
            GROUP BY zp.id_zona, zp.nombre
            ORDER BY pedidos_en_buffer DESC;
        """;
        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
        }
    }
}
