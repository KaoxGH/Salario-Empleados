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
public class GetExcelUsuariosRequestDto {

    private List<ExcelUsuario> excelInfo;

}