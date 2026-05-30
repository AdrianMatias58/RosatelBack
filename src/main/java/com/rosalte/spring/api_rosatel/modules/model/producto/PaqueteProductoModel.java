package com.rosalte.spring.api_rosatel.modules.model.producto;

import jakarta.persistence.*;

@Entity
@Table(name = "paquete_producto")
public class PaqueteProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paquete", nullable = false)
    private PaquetesModel paquete;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosModel producto;

    @Column(nullable = false)
    private Integer cantidad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PaquetesModel getPaquete() { return paquete; }
    public void setPaquete(PaquetesModel paquete) { this.paquete = paquete; }
    public ProductosModel getProducto() { return producto; }
    public void setProducto(ProductosModel producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}