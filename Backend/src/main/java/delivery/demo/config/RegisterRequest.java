package delivery.demo.config;

import java.awt.*;

public record RegisterRequest(
        String nombre,
        String direccion,
        String correo,
        String password,
        double latitude,
        double longitude
) { }