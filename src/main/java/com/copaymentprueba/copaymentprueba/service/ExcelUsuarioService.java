package com.copaymentprueba.copaymentprueba.service;

import com.copaymentprueba.copaymentprueba.service.filtros.Validator;
import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;
import com.copaymentprueba.copaymentprueba.repository.ExcelUsuarioRepository;
import com.copaymentprueba.copaymentprueba.service.interfaces.IExcelUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelUsuarioService implements IExcelUsuarioService {

    @Autowired
    private ExcelUsuarioRepository excelUsuarioRepository;

    @Override
    public List<ExcelUsuario> getAllEmpleados() {
        return null;
    }

    @Override
    public List<List<ExcelUsuario>> validarExcelUsuarios(List<ExcelUsuario> excelUsuarios) {
        List<ExcelUsuario> excelUsuariosValidados = new ArrayList<>();
        List<ExcelUsuario> excelUsuariosNoValidados = new ArrayList<>();
        for (ExcelUsuario excelUsuario:excelUsuarios){
            if (Validator.validate(excelUsuario))
                excelUsuariosValidados.add(excelUsuario);
            else excelUsuariosNoValidados.add(excelUsuario);
        }
        List <List<ExcelUsuario>> excelArrayUsuarios= new ArrayList<>();
        excelArrayUsuarios.add(excelUsuariosValidados);
        excelArrayUsuarios.add(excelUsuariosNoValidados);
        return excelArrayUsuarios;
    }
}
