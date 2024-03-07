package com.copaymentprueba.copaymentprueba.service.interfaces;

import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;
import com.copaymentprueba.copaymentprueba.dto.ExcelUsuariosResponseEntity;

import java.util.List;

public interface IExcelUsuarioService {

    List<ExcelUsuario> getAllEmpleados();

    void guardarExcelUsuarios(List<ExcelUsuario> excelUsuarios);

    List<ExcelUsuariosResponseEntity> validarExcelUsuariosEntities(List<ExcelUsuario> excelUsuarios);

    List<List<ExcelUsuario>> validarExcelUsuarios(List<ExcelUsuario> excelUsuarios);
}
