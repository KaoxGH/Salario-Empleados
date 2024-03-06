package com.copaymentprueba.copaymentprueba.dto;

import com.copaymentprueba.copaymentprueba.dao.entities.RegistroHoras;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.copaymentprueba.copaymentprueba.util.Functions.obtenerSalarioDiario;

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
        this.salarioDiario = obtenerSalarioDiario(
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
