package com.restfulapi.co.service;

import com.restfulapi.co.repository.DepartamentoRepository;
import com.restfulapi.co.entity.Departamento;
import com.restfulapi.co.service.interfaces.IDepartamentoService;
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
