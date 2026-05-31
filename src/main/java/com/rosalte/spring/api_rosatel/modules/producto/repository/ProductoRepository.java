package com.rosalte.spring.api_rosatel.modules.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rosalte.spring.api_rosatel.modules.model.producto.ProductosModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosModel, Long> {
}
