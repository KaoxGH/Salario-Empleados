package com.restfulapi.co.dto;

import com.restfulapi.co.entity.ExcelUsuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExcelUsuariosResponseEntity {
        private String empresa;
        private String nombre;
        private String segundoNombre;
        private String tercerNombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String fechaDeNacimiento;
        private String rfc;
        private String idEstado;
        private String curp;
        private String estadoCivil;
        private String telefono;
        private String telefonoParticular;
        private String correo;
        private String observaciones;
        private String cardNumber;
        private String errorMessage;
        private List<String> errorCampos;

        public ExcelUsuariosResponseEntity(ExcelUsuario excelUsuario) {
            this.empresa = excelUsuario.getEmpresa();
            this.nombre = excelUsuario.getNombre();
            this.segundoNombre = excelUsuario.getSegundoNombre();
            this.tercerNombre = excelUsuario.getTercerNombre();
            this.apellidoPaterno = excelUsuario.getApellidoPaterno();
            this.apellidoMaterno = excelUsuario.getApellidoMaterno();
            this.fechaDeNacimiento = excelUsuario.getFechaDeNacimiento();
            this.rfc = excelUsuario.getRfc();
            this.idEstado = excelUsuario.getIdEstado();
            this.curp = excelUsuario.getCurp();
            this.estadoCivil = excelUsuario.getEstadoCivil();
            this.telefono = excelUsuario.getTelefono();
            this.telefonoParticular = excelUsuario.getTelefonoParticular();
            this.correo = excelUsuario.getCorreo();
            this.observaciones = excelUsuario.getObservaciones();
            this.cardNumber = excelUsuario.getCardNumber();
            this.errorMessage= "";
        }
    }