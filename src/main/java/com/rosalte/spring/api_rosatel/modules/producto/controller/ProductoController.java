package com.rosalte.spring.api_rosatel.modules.producto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rosalte.spring.api_rosatel.modules.model.producto.ProductosModel;
import com.rosalte.spring.api_rosatel.modules.producto.service.ProductoService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductosModel> listarTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosModel> obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .map(producto -> ResponseEntity.ok(producto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductosModel crearProducto(@RequestPart("producto") String productoJson,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductosModel producto = objectMapper.readValue(productoJson, ProductosModel.class);
        return productoService.guardarProducto(producto, imagen);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductosModel> actualizarProducto(@PathVariable Long id,
            @RequestPart("producto") String productoJson,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductosModel detallesProducto = objectMapper.readValue(productoJson, ProductosModel.class);
        return productoService.obtenerPorId(id).map(productoExistente -> {
            productoExistente.setNombre(detallesProducto.getNombre());
            productoExistente.setPrecio(detallesProducto.getPrecio());
            productoExistente.setDescripcion(detallesProducto.getDescripcion());
            productoExistente.setStock(detallesProducto.getStock());
            productoExistente.setImagenUrl(detallesProducto.getImagenUrl());

            try {
                ProductosModel productoActualizado = productoService.guardarProducto(productoExistente, imagen);
                return ResponseEntity.ok(productoActualizado);
            } catch (IOException e) {
                throw new RuntimeException("Error al subir la imagen a Cloudinary", e);
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (productoService.obtenerPorId(id).isPresent()) {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
