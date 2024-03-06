package com.copaymentprueba.copaymentprueba.service;

import com.copaymentprueba.copaymentprueba.dao.entities.RegistroHoras;
import com.copaymentprueba.copaymentprueba.repository.RegistroHorasRepository;
import com.copaymentprueba.copaymentprueba.service.interfaces.IRegistroHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RegistroHorasService implements IRegistroHorasService {

    @Autowired
    private RegistroHorasRepository registroHorasRepository;

    @Override
    public RegistroHoras getRegistroHorasByEmpleado_Usuario(String usuario) {
        return registroHorasRepository.getRegistroHorasByEmpleado_Usuario(usuario);
    }

    @Override
    public RegistroHoras getRegistroHorasByEmpleado_UsuarioAndAndFecha(String usuario, LocalDate localDate) {
        return registroHorasRepository.getRegistroHorasByEmpleado_UsuarioAndAndFecha(usuario, localDate);
    }

    @Override
    public RegistroHoras updateRegistroHoras(RegistroHoras registroHoras) {
        return registroHorasRepository.save(registroHoras);
    }

    @Override
    @Transactional
    public RegistroHoras createRegistroHoras(RegistroHoras registroHoras) {
        return registroHorasRepository.save(registroHoras);
    }

    @Override
    public boolean existsRegistroHorasByEmpleado_Usuario(String usuario) {
        return registroHorasRepository.existsRegistroHorasByEmpleado_Usuario(usuario);
    }

    @Override
    public boolean existsRegistroHorasByFecha(LocalDate localDate) {
        return registroHorasRepository.existsRegistroHorasByFecha(localDate);
    }

    @Override
    public boolean existsRegistroHorasByEmpleado_UsuarioAndFecha(String usuario, LocalDate localDate) {
        return registroHorasRepository.existsRegistroHorasByEmpleado_UsuarioAndFecha(usuario, localDate);
    }

}
