package com.copaymentprueba.copaymentprueba.dto;

import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;
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

    private List<List<ExcelUsuario>> excelUsuariosValidados;
}
