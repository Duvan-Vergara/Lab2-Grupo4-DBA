package delivery.demo.services;

import delivery.demo.repositories.PedidoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public PedidoService(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Autowired
    private PedidoRepositoryImp pedidoRepositoryImp;

    public List<Map<String, Object>> obtenerMasPedidosPorCategoriaUltimoMes() {
        return pedidoRepositoryImp.obtenerMasPedidosPorCategoriaUltimoMes();
    }

    public List<Map<String, Object>> obtenerTiemposPromedioEntrega() {
        return pedidoRepositoryImp.obtenerTiemposPromedioEntrega();
    }

    public List<Map<String, Object>> obtenerPedidosQueCruzanMultiplesZonas() {
        return pedidoRepositoryImp.obtenerPedidosQueCruzanMultiplesZonas();
    }

    public Long registrarPedidoConProductos(
            Long idUrgencia,
            Long idRepartidor,
            Long idCliente,
            Long idMedioPago,
            String ubicacionEntrega,
            String rutaEstimada,
            List<Long> productos,
            List<Integer> cantidades
    ) {
        String sql = """
        SELECT registrar_pedido(
            :u, :r, :c, :m,
            ST_SetSRID(ST_MakePoint(:lon, :lat), 4326),
            ST_SetSRID(ST_GeomFromText(:re), 4326),
            :ids, :cts
        )
    """;

        String[] coord = ubicacionEntrega.trim().split("\\s+");
        double lon = Double.parseDouble(coord[0]);
        double lat = Double.parseDouble(coord[1]);

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("u", idUrgencia)
                .addValue("r", idRepartidor)
                .addValue("c", idCliente)
                .addValue("m", idMedioPago)
                .addValue("lon", lon)
                .addValue("lat", lat)
                .addValue("re", rutaEstimada)
                .addValue("ids", productos.toArray(new Long[0]))
                .addValue("cts", cantidades.toArray(new Integer[0]));

        return jdbc.queryForObject(sql, params, Long.class);
    }



    public void confirmarPedido(Long idPedido) {
        String sql = "SELECT confirmar_pedido(:id)";
        MapSqlParameterSource params = new MapSqlParameterSource("id", idPedido);
        jdbc.query(sql, params, rs -> null);
    }

    public boolean cambiarEstadoPedidoPorFuncion(Long idPedido, boolean nuevoEstado) {
        String sql = "SELECT cambiar_estado_pedido(:id, :estado)";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", idPedido)
                .addValue("estado", nuevoEstado);

        return jdbc.queryForObject(sql, params, Boolean.class);
    }

    public List<Map<String, Object>> obtenerTodosLosPedidos() {
        return pedidoRepositoryImp.obtenerTodosLosPedidos();
    }

    public void actualizarPedido(Long id, Map<String, Object> campos) {
        pedidoRepositoryImp.actualizarPedido(id, campos);
    }

    public void eliminarPedido(Long id) {
        pedidoRepositoryImp.eliminarPedido(id);
    }

    public List<Map<String, Object>> obtenerPedidosMasCercanosAEmpresa(Long idEmpresa) {
        return pedidoRepositoryImp.obtenerPedidosMasCercanosAEmpresa(idEmpresa);
    }

    public List<Map<String, Object>> obtenerPuntosInteres(Long idCliente, double radioMetros){
        return pedidoRepositoryImp.obtenerPuntosInteresCercanosPorCliente(idCliente, radioMetros);
    }

}
