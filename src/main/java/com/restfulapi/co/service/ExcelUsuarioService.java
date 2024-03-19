package com.restfulapi.co.service;

import com.restfulapi.co.dto.ExcelUsuariosResponseEntity;
import com.restfulapi.co.entity.ExcelUsuario;
import com.restfulapi.co.repository.ExcelUsuarioRepository;
import com.restfulapi.co.service.interfaces.IExcelUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static com.restfulapi.co.service.filtros.Validator.validate;
import static com.restfulapi.co.service.filtros.Validator.validateV2;

@Service
public class ExcelUsuarioService implements IExcelUsuarioService {

    @Autowired
    private ExcelUsuarioRepository excelUsuarioRepository;

    @Override
    public List<ExcelUsuario> getAllEmpleados() {
        return null;
    }

    @Override
    @Transactional
    public void guardarExcelUsuarios(List<ExcelUsuario> excelUsuarios){
        excelUsuarioRepository.saveAll(excelUsuarios);
    }

    @Override
    public List<List<ExcelUsuario>> validarExcelUsuarios(List<ExcelUsuario> excelUsuarios) {
        List<ExcelUsuario> excelUsuariosValidados = new ArrayList<>();
        List<ExcelUsuario> excelUsuariosNoValidados = new ArrayList<>();
        for (ExcelUsuario excelUsuario:excelUsuarios){
            if (validate(excelUsuario))
                excelUsuariosValidados.add(excelUsuario);
            else excelUsuariosNoValidados.add(excelUsuario);
        }
        List <List<ExcelUsuario>> excelArrayUsuarios= new ArrayList<>();
        excelArrayUsuarios.add(excelUsuariosValidados);
        excelArrayUsuarios.add(excelUsuariosNoValidados);
        return excelArrayUsuarios;
    }

    @Override
    public List<ExcelUsuariosResponseEntity> validarExcelUsuariosEntities(List<ExcelUsuario> excelUsuarios) {
        List<ExcelUsuariosResponseEntity> excelUsuariosNoValidados = new ArrayList<>();
        for (ExcelUsuario excelUsuario:excelUsuarios){
            ExcelUsuariosResponseEntity excelUsuariosEntity = new ExcelUsuariosResponseEntity(excelUsuario);
            List<String> errorCampos = validateV2(excelUsuariosEntity);
            if (!errorCampos.isEmpty()){
                excelUsuariosEntity.setErrorCampos(errorCampos);
                excelUsuariosNoValidados.add(excelUsuariosEntity);
            }
        }
        return excelUsuariosNoValidados;
    }
}
