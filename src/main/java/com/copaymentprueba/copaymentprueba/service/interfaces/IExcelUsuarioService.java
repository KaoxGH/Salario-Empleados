package com.copaymentprueba.copaymentprueba.service.interfaces;

import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;

import java.util.List;

public interface IExcelUsuarioService {

    List<ExcelUsuario> getAllEmpleados();

    List<List<ExcelUsuario>> validarExcelUsuarios(List<ExcelUsuario> excelUsuarios);
}
