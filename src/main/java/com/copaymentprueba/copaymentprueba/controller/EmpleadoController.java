package com.copaymentprueba.copaymentprueba.controller;
import com.copaymentprueba.copaymentprueba.dto.*;
import com.copaymentprueba.copaymentprueba.dao.entities.Empleado;

import com.copaymentprueba.copaymentprueba.dao.entities.RegistroHoras;
import com.copaymentprueba.copaymentprueba.service.interfaces.IEmpleadoService;
import com.copaymentprueba.copaymentprueba.service.interfaces.IRegistroHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/empleado/")
public class EmpleadoController {

    @Autowired
    IEmpleadoService iEmpleadoService;
    @Autowired
    IRegistroHorasService iRegistroHorasService;

    //Enpoint para registrar fecha, hora de entrada y salida de los empleados
    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> loginEmpleado(@RequestBody LoginRequestDto loginRequestDto){
        String usuario = loginRequestDto.getUsuario();
        if (iEmpleadoService.existsEmpleadoByUsuario(usuario)){
            Empleado empleado = iEmpleadoService.getEmpleadoByUsuario(usuario);
            RegistroHoras registroHoras;
            LoginResponseDto loginResponseDto;
            if(!iRegistroHorasService.existsRegistroHorasByEmpleado_UsuarioAndFecha(usuario, LocalDate.now())){
                registroHoras = new RegistroHoras(empleado); //Crea un registro de horas del empleado
                registroHoras.setFecha(LocalDate.now()); //Fecha actual
                registroHoras.setHoraEntrada(LocalTime.now()); //Hora actual de entrada
                iRegistroHorasService.createRegistroHoras(registroHoras); //Guarda el registro
                loginResponseDto = new LoginResponseDto(registroHoras);
                return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
            }else{
                registroHoras = iRegistroHorasService.getRegistroHorasByEmpleado_UsuarioAndAndFecha(usuario, LocalDate.now());
                registroHoras.setHoraSalida(LocalTime.now()); //Hora actual de salida
                iRegistroHorasService.updateRegistroHoras(registroHoras); //Actualiza el registro
                loginResponseDto = new LoginResponseDto(registroHoras);
                return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Enpoint para registrar fecha y hora de entrada de los empleados
    @PostMapping("consultar")
    public ResponseEntity<GetConsultaResponseDto> getConsulta(@RequestBody GetConsultaRequestDto getConsultaRequestDto) {
        String usuario = getConsultaRequestDto.getUsuario();
        LocalDate localDate = getConsultaRequestDto.getFecha();
        if (iRegistroHorasService.existsRegistroHorasByEmpleado_UsuarioAndFecha(usuario,localDate)){
            RegistroHoras registroHoras = iRegistroHorasService.getRegistroHorasByEmpleado_UsuarioAndAndFecha(usuario,localDate);
            GetConsultaResponseDto responseDto = new GetConsultaResponseDto(registroHoras);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Endpoint para obtener todos los empleados
    @PostMapping("getAllEmpleados")
    public ResponseEntity<List<GetEmpleadoResponseDto>> getAllEmpleados() {
        List<Empleado> empleados = iEmpleadoService.getAllEmpleados();
        List<GetEmpleadoResponseDto> responseDto = new ArrayList<>();
        for(Empleado empleado: empleados){
            GetEmpleadoResponseDto dto = new GetEmpleadoResponseDto();
            dto.setResponseData(empleado);
            responseDto.add(dto);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // Endpoint para obtener un empleado por ID
    @PostMapping("getEmpleado")
    public ResponseEntity<GetEmpleadoResponseDto> getEmpleadoByUsuario(@RequestBody GetEmpleadoRequestDto getEmpleadoRequestDto) {
        Empleado empleado = iEmpleadoService.getEmpleadoByUsuario(getEmpleadoRequestDto.getUsuario());
        if (empleado != null) {
            GetEmpleadoResponseDto responseDto = new GetEmpleadoResponseDto();
            responseDto.setResponseCode("00");
            responseDto.setResponseMessage("Petición exitosa");
            responseDto.setResponseData(empleado);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo empleado
    @PostMapping("createEmpleado")
    public ResponseEntity<GetEmpleadoResponseDto> createEmpleado(@RequestBody Empleado empleado) {
        if(!iEmpleadoService.existsEmpleadoByUsuario(empleado.getUsuario())) {
            Empleado nuevoEmpleado = iEmpleadoService.createEmpleado(empleado);
            GetEmpleadoResponseDto responseDto = new GetEmpleadoResponseDto();
            responseDto.setResponseData(nuevoEmpleado);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Endpoint para actualizar un empleado existente
    @PostMapping("updateEmpleado")
    public ResponseEntity<GetEmpleadoResponseDto> updateEmpleado(@RequestBody Empleado empleado) {
        if(iEmpleadoService.existsEmpleadoByUsuario(empleado.getUsuario())) {
            Empleado empleadoActualizado = iEmpleadoService.updateEmpleadoByUsuario(empleado.getUsuario(), empleado);
            GetEmpleadoResponseDto responseDto = new GetEmpleadoResponseDto();
            responseDto.setResponseData(empleadoActualizado);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un empleado por ID
    @PostMapping("deleteEmpleado")
    public ResponseEntity<Void> deleteEmpleado(@RequestBody GetEmpleadoRequestDto getEmpleadoRequestDto) {
        boolean eliminado = iEmpleadoService.deleteEmpleadoByUsuario(getEmpleadoRequestDto.getUsuario());
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /*@PostMapping("createEmpleado")
    public ResponseEntity<GetEmpleadoResponseDto> createEmpleado(@RequestBody GetEmpleadoRequestDto getEmpleadoRequestDto) {
        Empleado nuevoEmpleado = iEmpleadoService.createEmpleado(getEmpleadoRequestDto);
        GetEmpleadoResponseDto responseDto = new GetEmpleadoResponseDto();
        responseDto.setResponseData(nuevoEmpleado);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }*/
    /*@PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") Long id, @RequestBody Empleado empleado) {
        Empleado empleadoActualizado = iEmpleadoService.updateEmpleado(id, empleado);
        if (empleadoActualizado != null) {
            return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable("id") Long id) {
        boolean eliminado = iEmpleadoService.deleteEmpleado(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

}
