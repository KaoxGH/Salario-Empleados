package com.copaymentprueba.copaymentprueba.service.interfaces;

import com.copaymentprueba.copaymentprueba.dao.entities.RegistroHoras;

import java.time.LocalDate;

public interface IRegistroHorasService {

    RegistroHoras getRegistroHorasByEmpleado_Usuario(String usuario);
    RegistroHoras getRegistroHorasByEmpleado_UsuarioAndAndFecha(String usuario, LocalDate localDate);
    RegistroHoras createRegistroHoras(RegistroHoras registroHoras);
    RegistroHoras updateRegistroHoras(RegistroHoras registroHoras);
    boolean existsRegistroHorasByEmpleado_Usuario(String usuario);

    boolean existsRegistroHorasByFecha(LocalDate localDate);

    boolean existsRegistroHorasByEmpleado_UsuarioAndFecha(String usuario, LocalDate localDate);
}
