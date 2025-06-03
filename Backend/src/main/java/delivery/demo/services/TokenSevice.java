package delivery.demo.services;

import delivery.demo.config.LoginRequest;
import delivery.demo.config.RegisterRequest;
import delivery.demo.config.TokenResponse;
import delivery.demo.entities.ClienteEntity;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class TokenSevice {

    public TokenSevice(ClienteService clienteService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.clienteService = clienteService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private final ClienteService clienteService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse register(final RegisterRequest request) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point direccionn = geometryFactory.createPoint(new Coordinate(request.longitude(), request.latitude()));
        direccionn.setSRID(4326);

        ClienteEntity cliente = new ClienteEntity(
                null,
                request.nombre(),
                request.direccion(),
                request.correo(),
                passwordEncoder.encode(request.password()),
                null,
                direccionn
        );

        clienteService.save(cliente);
        var jwtToken = jwtService.generateToken(cliente);
        return new TokenResponse(jwtToken);
    }

    public TokenResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.correo(),
                        request.password()
                )
        );
        System.out.println("correo: " + request.correo());
        var cliente = clienteService.findByCorreo(request.correo());

        var jwtToken = jwtService.generateToken(cliente);
        return new TokenResponse(jwtToken);
    }

    public TokenResponse refreshToken( String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Refresh Token");
        }
        final String refreshToken = authHeader.substring(7);
        final String userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail == null) {
            throw new IllegalArgumentException("Invalid Refresh Token");
        }
        final ClienteEntity cliente = clienteService.findByCorreo(userEmail);
        if (!jwtService.isTokenValid(refreshToken)) {
            throw new IllegalArgumentException("Invalid Refresh Token");

        }
        final String accessToken = jwtService.generateToken(cliente);
        return new TokenResponse(accessToken);
    }

}