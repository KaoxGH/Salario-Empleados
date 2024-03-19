package com.restfulapi.co.controller;


import com.restfulapi.co.entity.ExcelUsuario;
import com.restfulapi.co.dto.ExcelUsuariosResponseEntity;
import com.restfulapi.co.dto.GetExcelUsuariosRequestDto;
import com.restfulapi.co.dto.GetExcelUsuariosResponseDto;
import com.restfulapi.co.service.ExcelUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/excel/")
@CrossOrigin(origins = "http://localhost:5173")
public class ExcelUsuarioController {

    @Autowired
    ExcelUsuarioService excelUsuarioService;

    @PostMapping("getExcelUsuarios")
    public ResponseEntity<GetExcelUsuariosResponseDto> getExcelUsuarios(@RequestBody GetExcelUsuariosRequestDto requestDto){
        GetExcelUsuariosResponseDto responseDto = new GetExcelUsuariosResponseDto();
        List<List<ExcelUsuario>> arrayDeArrays = excelUsuarioService.validarExcelUsuarios(requestDto.getExcelInfo());
        if(arrayDeArrays.get(1).isEmpty()) //si el segundo Arreglo dentro del arreglo de arreglos no tiene nada, significa que todos los usuarios están validados
        {
            responseDto.setResponseCode("00");
            responseDto.setResponseMessage("Los usuarios validados se han guardado con exito.");
            return new ResponseEntity<>(HttpStatus.OK);

            }else {
                responseDto.setExcelUsuariosValidados(arrayDeArrays);
                responseDto.setResponseCode("00");
                responseDto.setResponseMessage("Los usuarios han sido enviados con exito. Faltan usuarios por validar");
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }
    }


    @PostMapping("getExcelUsuariosV2")
    public ResponseEntity<GetExcelUsuariosResponseDto> getExcelUsuariosV2(@RequestBody GetExcelUsuariosRequestDto requestDto) {
        GetExcelUsuariosResponseDto responseDto = new GetExcelUsuariosResponseDto();
        List<ExcelUsuariosResponseEntity> excelUsuariosNoValidados = excelUsuarioService.validarExcelUsuariosEntities(requestDto.getExcelInfo());
        if (excelUsuariosNoValidados.isEmpty()){
            excelUsuarioService.guardarExcelUsuarios(requestDto.getExcelInfo());
            responseDto.setResponseCode("00");
            responseDto.setResponseMessage("Los usuarios validados se han guardado con exito.");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            responseDto.setResponseData(excelUsuariosNoValidados);
            responseDto.setResponseCode("15");
            responseDto.setResponseMessage("Campos erróneos");
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
    }

}
