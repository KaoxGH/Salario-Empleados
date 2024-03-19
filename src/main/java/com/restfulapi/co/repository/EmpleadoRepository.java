package com.restfulapi.co.repository;

import com.restfulapi.co.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findEmpleadoByUsuario(String usuario);
}
