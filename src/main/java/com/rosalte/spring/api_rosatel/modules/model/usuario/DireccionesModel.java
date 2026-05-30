package com.rosalte.spring.api_rosatel.modules.model.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class DireccionesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClientesModel cliente;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(length = 200)
    private String referencia;

    @Column(name = "codigo_postal", length = 6)
    private String codigoPostal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ClientesModel getCliente() { return cliente; }
    public void setCliente(ClientesModel cliente) { this.cliente = cliente; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
}