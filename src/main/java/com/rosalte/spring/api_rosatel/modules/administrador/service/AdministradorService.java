package com.rosalte.spring.api_rosatel.modules.administrador.service;

import com.rosalte.spring.api_rosatel.modules.model.usuario.UsuariosModel;
import com.rosalte.spring.api_rosatel.modules.administrador.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public List<UsuariosModel> listarTodos() {
        return administradorRepository.findAll();
    }

    public UsuariosModel guardar(UsuariosModel administrador) {
        return administradorRepository.save(administrador);
    }

    public Optional<UsuariosModel> buscarPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public void eliminar(Long id) {
        administradorRepository.deleteById(id);
    }
}