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
public class GetExcelUsuariosResponseDto extends ResponseBaseDto{

    /*private String empresa;
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
    private String cardNumber;*/
    private List<List<ExcelUsuario>> excelUsuariosValidados;

    private List<ExcelUsuariosResponseEntity> responseData;
}
