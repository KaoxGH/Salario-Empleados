package com.restfulapi.co.dto;

import com.restfulapi.co.entity.RegistroHoras;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restfulapi.co.util.Functions;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetConsultaResponseDto {

    private String usuario;
    private LocalDate fecha;
    private LocalTime horaDeEntrada;
    private LocalTime horaDeSalida;
    private double salarioDiario;

    public GetConsultaResponseDto() {
    }

    public GetConsultaResponseDto(RegistroHoras registroHoras) {
        this.usuario = registroHoras.getEmpleado().getUsuario();
        this.fecha = registroHoras.getFecha();
        this.horaDeEntrada = registroHoras.getHoraEntrada();
        this.horaDeSalida = registroHoras.getHoraSalida();
        this.salarioDiario = Functions.obtenerSalarioDiario(
                registroHoras.getHoraEntrada(),
                registroHoras.getHoraSalida(),
                registroHoras.getEmpleado().getDepartamento().getTarifaPorHora());
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public LocalTime getHoraDeSalida() {
        return horaDeSalida;
    }

    public Double getSalarioDiario() {
        return salarioDiario;
    }

}
