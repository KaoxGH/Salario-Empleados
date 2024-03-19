package com.restfulapi.co.service.interfaces;
import com.restfulapi.co.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> getAllEmpleados();
    public Empleado getEmpleadoByUsuario(String usuario);
    public Empleado createEmpleado(Empleado empleado);
    public Empleado updateEmpleadoByUsuario(String usuario, Empleado empleado);
    public boolean deleteEmpleadoByUsuario(String usuario);
    public boolean existsEmpleadoByUsuario(String usuario);
}
