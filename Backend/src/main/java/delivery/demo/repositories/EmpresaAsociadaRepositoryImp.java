package delivery.demo.repositories;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Repository
public class EmpresaAsociadaRepositoryImp {

    private final Sql2o sql2o;

    public EmpresaAsociadaRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Map<String, Object>> obtenerEntregasFallidasPorEmpresa() {
        String sql = """
                    SELECT 
                      ea.nombre,
                      COUNT(*) AS entregas_fallidas
                    FROM 
                      EMPRESA_ASOCIADA ea
                    JOIN 
                      REPARTIDOR r ON r.id_empresa_asociada = ea.id_empresa_asociada
                    JOIN 
                      PEDIDO p ON p.id_repartidor = r.id_repartidor
                    JOIN 
                      DETALLE_PEDIDO dp ON dp.id_detalle_pedido = p.id_detalle_pedido
                    WHERE 
                      dp.entregado = FALSE
                     AND ea.deleted_at IS NULL
                    AND r.deleted_at IS NULL
                    AND p.deleted_at IS NULL
                    AND dp.deleted_at IS NULL
                    GROUP BY 
                      ea.id_empresa_asociada, ea.nombre
                    ORDER BY 
                      entregas_fallidas DESC
                """;

        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
        }
    }

    public List<Map<String, Object>> obtenerEntregasExitosasPorEmpresa() {
        String sql = """
                    SELECT 
                      ea.id_empresa_asociada,
                      ea.nombre,
                      COUNT(*) AS total_entregados
                    FROM 
                      EMPRESA_ASOCIADA ea
                    JOIN 
                      REPARTIDOR r ON r.id_empresa_asociada = ea.id_empresa_asociada
                    JOIN 
                      PEDIDO p ON p.id_repartidor = r.id_repartidor
                    JOIN 
                      DETALLE_PEDIDO dp ON dp.id_detalle_pedido = p.id_detalle_pedido
                    WHERE 
                      dp.entregado = TRUE
                    AND ea.deleted_at IS NULL
                    AND r.deleted_at IS NULL
                    AND p.deleted_at IS NULL
                    AND dp.deleted_at IS NULL
                    GROUP BY 
                      ea.id_empresa_asociada, ea.nombre
                    ORDER BY 
                      total_entregados DESC
                """;

        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
        }
    }

    //Consulta 4
    public List<Map<String, Object>> obtenerPedidoMasLejanoPorEmpresa() {
        String sql = """
        SELECT
          e.id_empresa_asociada,
          e.nombre AS empresa,
          p.id_pedido,
          ST_Distance(e.ubicacion_empresa_asociada, p.ubicacion_entrega) AS distancia
        FROM EMPRESA_ASOCIADA e
        JOIN PEDIDO p ON p.id_pedido = (
          SELECT p2.id_pedido
          FROM PEDIDO p2
          ORDER BY ST_Distance(e.ubicacion_empresa_asociada, p2.ubicacion_entrega) DESC
          LIMIT 1
        );
    """;

        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
        }
    }

    //Consulta 6
    public List<Map<String, Object>> obtenerClientesSinEmpresaCercana() {
        String sql = """
        SELECT c.id_cliente, c.nombre
        FROM cliente c
        WHERE NOT EXISTS (
          SELECT 1
          FROM empresa_asociada e
          WHERE ST_Distance(c.ubicacion_cliente, e.ubicacion_empresa_asociada) <= 0.045
        );
    """;

        try (org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetchTable()
                    .asList();
        }
    }


}
