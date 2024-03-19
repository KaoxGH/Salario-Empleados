package com.restfulapi.co.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetConsultaRequestDto {

    private String usuario;
    private LocalDate fecha;

    public GetConsultaRequestDto() {
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

}
