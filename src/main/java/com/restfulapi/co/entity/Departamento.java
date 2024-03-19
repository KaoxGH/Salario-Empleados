package com.restfulapi.co.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departamento_id")
    private Long departamentoId;

    @Column(name = "nombre_departamento")
    private String nombreDepartamento;

    @Column(name = "tarifa_por_hora", nullable = false)
    private Double tarifaPorHora;

    public Departamento() {
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(Double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "departamentoId=" + departamentoId +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                ", tarifaPorHora=" + tarifaPorHora +
                '}';
    }
}