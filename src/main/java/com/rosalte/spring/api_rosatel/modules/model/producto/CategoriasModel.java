package com.rosalte.spring.api_rosatel.modules.model.producto;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombreCategoria", nullable = false, length = 60)
    private String nombreCategoria;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }
}