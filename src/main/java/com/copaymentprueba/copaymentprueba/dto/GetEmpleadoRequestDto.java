package com.copaymentprueba.copaymentprueba.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmpleadoRequestDto{
    private String usuario;
    private String password;
    private long departamentoId;

    public GetEmpleadoRequestDto() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(long departamentoId) {
        this.departamentoId = departamentoId;
    }
}
