package com.copaymentprueba.copaymentprueba.service;

import com.copaymentprueba.copaymentprueba.dto.ExcelUsuariosResponseEntity;
import com.copaymentprueba.copaymentprueba.dto.GetExcelUsuariosRequestDto;
import com.copaymentprueba.copaymentprueba.service.filtros.Validator;
import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;
import com.copaymentprueba.copaymentprueba.repository.ExcelUsuarioRepository;
import com.copaymentprueba.copaymentprueba.service.interfaces.IExcelUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static com.copaymentprueba.copaymentprueba.service.filtros.Validator.validate;
import static com.copaymentprueba.copaymentprueba.service.filtros.Validator.validateV2;

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
