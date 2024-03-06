package com.copaymentprueba.copaymentprueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.copaymentprueba.copaymentprueba.dao.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findEmpleadoByUsuario(String usuario);
}
