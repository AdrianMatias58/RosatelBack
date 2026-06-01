package com.rosalte.spring.api_rosatel.modules.administrador.controller;

import com.rosalte.spring.api_rosatel.modules.model.usuario.UsuariosModel;
import com.rosalte.spring.api_rosatel.modules.administrador.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    // GET: Obtener lista de administradores
    @GetMapping
    public ResponseEntity<List<UsuariosModel>> obtenerTodos() {
        return ResponseEntity.ok(administradorService.listarTodos());
    }

    // POST: Registrar un nuevo administrador
    @PostMapping
    public ResponseEntity<UsuariosModel> registrar(@RequestBody UsuariosModel administrador) {
        UsuariosModel nuevo = administradorService.guardar(administrador);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // PUT: Actualizar datos de un administrador
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> editar(@PathVariable Long id, @RequestBody UsuariosModel detalles) {
        return administradorService.buscarPorId(id)
                .map(admin -> {
                    admin.setCorreo(detalles.getCorreo());
                    admin.setPassword(detalles.getPassword());
                    admin.setRol(detalles.getRol());
                    admin.setGoogleId(detalles.getGoogleId());
                    admin.setRememberToken(detalles.getRememberToken());

                    UsuariosModel actualizado = administradorService.guardar(admin);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar administrador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        administradorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
