package com.restfulapi.co.repository;

import com.restfulapi.co.entity.RegistroHoras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RegistroHorasRepository extends JpaRepository<RegistroHoras, Long> {

    RegistroHoras getRegistroHorasByEmpleado_Usuario(String usuario);
    RegistroHoras getRegistroHorasByEmpleado_UsuarioAndAndFecha(String usuario, LocalDate localDate);
    boolean existsRegistroHorasByEmpleado_Usuario(String usuario);
    boolean existsRegistroHorasByFecha(LocalDate localDate);
    boolean existsRegistroHorasByEmpleado_UsuarioAndFecha(String usuario, LocalDate localDate);
}
