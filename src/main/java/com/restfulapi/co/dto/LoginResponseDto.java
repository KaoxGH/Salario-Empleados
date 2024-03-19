package com.restfulapi.co.dto;

import com.restfulapi.co.entity.RegistroHoras;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDto {

    private String usuario;
    private LocalDate fecha;
    private LocalTime horaDeEntrada;
    private LocalTime horaDeSalida;

    public LoginResponseDto() {
    }

    public LoginResponseDto(RegistroHoras registroHoras) {
        this.usuario = registroHoras.getEmpleado().getUsuario();
        this.fecha = registroHoras.getFecha();
        this.horaDeEntrada = registroHoras.getHoraEntrada();
        this.horaDeSalida = registroHoras.getHoraSalida();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public void setHoraDeEntrada(LocalTime horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public LocalTime getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(LocalTime horaDeSalida) {
        this.horaDeSalida = horaDeSalida;
    }
}
