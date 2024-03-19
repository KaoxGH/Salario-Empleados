package com.restfulapi.co.service;

import com.restfulapi.co.repository.EmpleadoRepository;
import com.restfulapi.co.entity.Empleado;
import com.restfulapi.co.service.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getAllEmpleados() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public Empleado getEmpleadoByUsuario(String usuario) {
        Empleado empleado = empleadoRepository.findEmpleadoByUsuario(usuario);
        return empleado;
    }

    @Override
    @Transactional
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Empleado updateEmpleadoByUsuario(String usuario, Empleado empleado) {
        // Verificar si el empleado con el ID proporcionado existe en la base de datos
        Empleado updtatedEmpleado = empleadoRepository.findEmpleadoByUsuario(usuario);
        if (updtatedEmpleado!=null) {
            updtatedEmpleado.setUsuario(empleado.getUsuario());
            updtatedEmpleado.setPassword(empleado.getPassword());
            updtatedEmpleado.setDepartamento(empleado.getDepartamento());

            // Guardar los cambios en la base de datos
            return empleadoRepository.save(updtatedEmpleado);
        } else {
            // Si el empleado no existe, devolver null o lanzar una excepción según sea necesario
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteEmpleadoByUsuario(String usuario) {
        // Verificar si el empleado con el ID proporcionado existe en la base de datos
        Empleado deletedEmpleado = empleadoRepository.findEmpleadoByUsuario(usuario);
        if (deletedEmpleado!=null) {
            // Eliminar el empleado de la base de datos
            empleadoRepository.delete(deletedEmpleado);
            return true;
        } else {
            // Si el empleado no existe, devolver false
            return false;
        }
    }

    @Override
    public boolean existsEmpleadoByUsuario(String usuario) {
        Empleado empleado = empleadoRepository.findEmpleadoByUsuario(usuario);
        return empleado!=null;
    }
}
