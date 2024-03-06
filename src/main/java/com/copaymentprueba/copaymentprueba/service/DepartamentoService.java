package com.copaymentprueba.copaymentprueba.service;

import com.copaymentprueba.copaymentprueba.repository.DepartamentoRepository;
import com.copaymentprueba.copaymentprueba.dao.entities.Departamento;
import com.copaymentprueba.copaymentprueba.service.interfaces.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    @Transactional
    public Departamento findDepartamentoById() {
        return null;
    }
}
