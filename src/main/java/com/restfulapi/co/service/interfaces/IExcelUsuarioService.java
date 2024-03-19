package com.restfulapi.co.service.interfaces;

import com.restfulapi.co.entity.ExcelUsuario;
import com.restfulapi.co.dto.ExcelUsuariosResponseEntity;

import java.util.List;

public interface IExcelUsuarioService {

    List<ExcelUsuario> getAllEmpleados();

    void guardarExcelUsuarios(List<ExcelUsuario> excelUsuarios);

    List<ExcelUsuariosResponseEntity> validarExcelUsuariosEntities(List<ExcelUsuario> excelUsuarios);

    List<List<ExcelUsuario>> validarExcelUsuarios(List<ExcelUsuario> excelUsuarios);
}
