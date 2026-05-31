package com.rosalte.spring.api_rosatel.modules.producto.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rosalte.spring.api_rosatel.modules.model.producto.ProductosModel;
import com.rosalte.spring.api_rosatel.modules.producto.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public List<ProductosModel> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<ProductosModel> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public ProductosModel guardarProducto(ProductosModel producto, MultipartFile imagen) throws IOException {
        if (imagen != null && !imagen.isEmpty()) {
            Map uploadResult = cloudinaryService.upload(imagen);
            producto.setImagenUrl(uploadResult.get("url").toString());
        }
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
