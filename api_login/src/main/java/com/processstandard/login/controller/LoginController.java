package com.processstandard.login.controller;

import com.processstandard.login.model.LoginRequest;
import com.processstandard.login.model.Usuario;
import com.processstandard.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/login") // Define la ruta base del endpoint como /login
public class LoginController {

    @Autowired // Inyecta el servicio que se encargará de la lógica de autenticación
    private LoginService loginService;

    /**
     * Endpoint POST para iniciar sesión.
     * Recibe un objeto con el nombre de usuario y la contraseña desde el frontend.
     * Llama al servicio para obtener el usuario si las credenciales coinciden.
     * Si el usuario existe, se devuelve un mensaje de acceso permitido junto con su nombre y rol.
     * Si no existe, se devuelve un mensaje de error.
     *
     * @param request Objeto que contiene el nombre de usuario y la contraseña.
     * @return Un objeto JSON con el mensaje y el rol si las credenciales son válidas.
     */
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Llama al servicio para obtener el usuario por sus credenciales
        Usuario usuario = loginService.obtenerUsuarioPorCredenciales(request);

        if (usuario != null) {
            // Se crea un mapa para devolver los datos del usuario y el rol
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Acceso permitido. ¡Bienvenido!");
            response.put("usuario", usuario.getUsuario()); // Se devuelve el nombre de usuario
            response.put("rol", usuario.getRol()); // Se devuelve el rol (ADMIN o USER)
            return ResponseEntity.ok(response); // Se responde con estado 200 OK y el mapa
        } else {
            // Si no se encuentra el usuario, se devuelve un mensaje de error con estado 401
            return ResponseEntity.status(401).body("Credenciales incorrectas.");
        }
    }
}