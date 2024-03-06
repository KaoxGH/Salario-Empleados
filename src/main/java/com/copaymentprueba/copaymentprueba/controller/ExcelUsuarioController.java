package com.copaymentprueba.copaymentprueba.controller;


import com.copaymentprueba.copaymentprueba.dto.GetEmpleadoResponseDto;
import com.copaymentprueba.copaymentprueba.dto.GetExcelUsuariosRequestDto;
import com.copaymentprueba.copaymentprueba.dto.GetExcelUsuariosResponseDto;
import com.copaymentprueba.copaymentprueba.service.ExcelUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excel/")
public class ExcelUsuarioController {

    @Autowired
    ExcelUsuarioService excelUsuarioService;

    @PostMapping("getExcelUsuarios")
    public ResponseEntity<GetExcelUsuariosResponseDto> getExcelUsuarios(@RequestBody GetExcelUsuariosRequestDto requestDto){
        GetExcelUsuariosResponseDto responseDto = new GetExcelUsuariosResponseDto();
        responseDto.setExcelUsuariosValidados(excelUsuarioService.validarExcelUsuarios(requestDto.getExcelUsuarios()));
        responseDto.setResponseCode("00");
        responseDto.setResponseMessage("Los usuarios validados se han enviado con exito.");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
