package com.rosalte.spring.api_rosatel.modules.administrador.repository;

import com.rosalte.spring.api_rosatel.modules.model.usuario.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<UsuariosModel, Long> {
}