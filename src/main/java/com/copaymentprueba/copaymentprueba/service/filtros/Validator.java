package com.copaymentprueba.copaymentprueba.service.filtros;

import com.copaymentprueba.copaymentprueba.dao.entities.ExcelUsuario;
import com.copaymentprueba.copaymentprueba.dto.ExcelUsuariosResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    // Regular expressions for validation
    private static final String EMPRESA_REGEX = "^[A-Z]+$";
    private static final String NOMBRE_REGEX = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s\\-']+$";
    private static final String FECHA_NACIMIENTO_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String RFC_REGEX = "^[A-ZÑ&]{3,4}\\d{6}[A-V1-9][A-Z1-9]\\d$";
    private static final String ID_ESTADO_REGEX = "^\\d{1,32}$";
    private static final String CURP_REGEX = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[0-9A-Z]{2}$";
    private static final String ESTADO_CIVIL_REGEX = "^(S|CS|CM|CC|V|D|U)$";
    private static final String TELEFONO_REGEX = "^\\d{8}$";
    private static final String TELEFONO_PARTICULAR_REGEX = "^\\d{10}$";
    private static final String CORREO_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String OBSERVACIONES_REGEX = "";
    private static final String CARD_NUMBER_REGEX = "^\\d{16}$";

    // Method to validate an ExcelUsuario object
    public static boolean validate(ExcelUsuario usuario) {
        if (usuario == null) {
            return false; // Object is null, cannot validate
        }

        // Validate each field using regular expressions
        boolean isValidEmpresa = validateField(usuario.getEmpresa(), EMPRESA_REGEX);
        boolean isValidNombre = validateField(usuario.getNombre(), NOMBRE_REGEX);
        //boolean isValidSegundoNombre = validateField(usuario.getSegundoNombre(), SEGUNDO_NOMBRE_REGEX);
        //boolean isValidTercerNombre = validateField(usuario.getTercerNombre(), TERCER_NOMBRE_REGEX);
        boolean isValidApellidoPaterno = validateField(usuario.getApellidoPaterno(), NOMBRE_REGEX);
        boolean isValidApellidoMaterno = validateField(usuario.getApellidoMaterno(), NOMBRE_REGEX);
        boolean isValidCorreo = validateField(usuario.getCorreo(), CORREO_REGEX);
        boolean isValidFechaNacimiento = validateField(usuario.getFechaDeNacimiento(), FECHA_NACIMIENTO_REGEX);
        boolean isValidRFC = validateField(usuario.getRfc(), RFC_REGEX);
        boolean isValidIdEstado = validateField(usuario.getIdEstado(), ID_ESTADO_REGEX);
        boolean isValidCURP = validateField(usuario.getCurp(), CURP_REGEX);
        boolean isValidEstadoCivil = validateField(usuario.getEstadoCivil(), ESTADO_CIVIL_REGEX);
        boolean isValidTelefono = validateField(usuario.getTelefono(), TELEFONO_REGEX);
        //boolean isValidTelefonoParticular = validateField(usuario.getTelefonoParticular(), TELEFONO_PARTICULAR_REGEX);
        //boolean isValidObservaciones = validateField(usuario.getObservaciones(), OBSERVACIONES_REGEX);
        boolean isValidCardNumber = validateField(usuario.getCardNumber(), CARD_NUMBER_REGEX);

        // Optional fields
        boolean isValidSegundoNombre = true; // Assume it's valid by default
        if (usuario.getSegundoNombre() != null) {
            isValidSegundoNombre = validateField(usuario.getSegundoNombre(), NOMBRE_REGEX);
        }

        boolean isValidTercerNombre = true; // Assume it's valid by default
        if (usuario.getTercerNombre() != null) {
            isValidTercerNombre = validateField(usuario.getTercerNombre(), NOMBRE_REGEX);
        }

        boolean isValidTelefonoParticular = true; // Assume it's valid by default
        if (usuario.getTelefonoParticular() != null) {
            isValidTelefonoParticular = validateField(usuario.getTelefonoParticular(), TELEFONO_PARTICULAR_REGEX);
        }

        boolean isValidObservaciones = true; // Assume it's valid by default
        if (usuario.getObservaciones() != null) {
            isValidObservaciones = validateField(usuario.getObservaciones(), OBSERVACIONES_REGEX);
        }

        // Return true if all fields are valid, false otherwise
        return isValidEmpresa &&
                isValidNombre &&
                isValidSegundoNombre &&
                isValidTercerNombre &&
                isValidApellidoPaterno &&
                isValidApellidoMaterno &&
                isValidCorreo &&
                isValidFechaNacimiento &&
                isValidRFC &&
                isValidIdEstado &&
                isValidCURP &&
                isValidEstadoCivil &&
                isValidTelefono &&
                isValidTelefonoParticular &&
                //isValidObservaciones &&
                isValidCardNumber;
    }

    public static List<String> validateV2(ExcelUsuariosResponseEntity usuario) {

        List<String> camposInvalidos = new ArrayList<>();

        // Validate each field using regular expressions
        boolean isValidEmpresa = validateField(usuario.getEmpresa(), EMPRESA_REGEX);
        boolean isValidNombre = validateField(usuario.getNombre(), NOMBRE_REGEX);
        //boolean isValidSegundoNombre = validateField(usuario.getSegundoNombre(), SEGUNDO_NOMBRE_REGEX);
        //boolean isValidTercerNombre = validateField(usuario.getTercerNombre(), TERCER_NOMBRE_REGEX);
        boolean isValidApellidoPaterno = validateField(usuario.getApellidoPaterno(), NOMBRE_REGEX);
        boolean isValidApellidoMaterno = validateField(usuario.getApellidoMaterno(), NOMBRE_REGEX);
        boolean isValidCorreo = validateField(usuario.getCorreo(), CORREO_REGEX);
        boolean isValidFechaNacimiento = validateField(usuario.getFechaDeNacimiento(), FECHA_NACIMIENTO_REGEX);
        boolean isValidRFC = validateField(usuario.getRfc(), RFC_REGEX);
        boolean isValidIdEstado = validateField(usuario.getIdEstado(), ID_ESTADO_REGEX);
        boolean isValidCURP = validateField(usuario.getCurp(), CURP_REGEX);
        boolean isValidEstadoCivil = validateField(usuario.getEstadoCivil(), ESTADO_CIVIL_REGEX);
        boolean isValidTelefono = validateField(usuario.getTelefono(), TELEFONO_REGEX);
        //boolean isValidTelefonoParticular = validateField(usuario.getTelefonoParticular(), TELEFONO_PARTICULAR_REGEX);
        //boolean isValidObservaciones = validateField(usuario.getObservaciones(), OBSERVACIONES_REGEX);
        boolean isValidCardNumber = validateField(usuario.getCardNumber(), CARD_NUMBER_REGEX);

        // Optional fields
        boolean isValidSegundoNombre = true; // Assume it's valid by default
        if (usuario.getSegundoNombre() != null) {
            isValidSegundoNombre = usuario.getSegundoNombre().isBlank() || validateField(usuario.getSegundoNombre(), NOMBRE_REGEX);
        }

        boolean isValidTercerNombre = true; // Assume it's valid by default
        if (usuario.getTercerNombre() != null) {
            isValidTercerNombre = usuario.getTercerNombre().isBlank() || validateField(usuario.getTercerNombre(), NOMBRE_REGEX);
        }

        boolean isValidTelefonoParticular = true; // Assume it's valid by default
        if (usuario.getTelefonoParticular() != null) {
            isValidTelefonoParticular = usuario.getTelefonoParticular().isBlank() || validateField(usuario.getTelefonoParticular(), TELEFONO_PARTICULAR_REGEX);
        }

        boolean isValidObservaciones = true; // Assume it's valid by default
        if (usuario.getObservaciones() != null) {
            isValidObservaciones = usuario.getObservaciones().isBlank() || validateField(usuario.getObservaciones(), OBSERVACIONES_REGEX);
        }

        if (!isValidEmpresa) camposInvalidos.add("Empresa");
        if (!isValidNombre) camposInvalidos.add("Nombre");
        if (!isValidSegundoNombre) camposInvalidos.add("Segundo Nombre");
        if (!isValidTercerNombre) camposInvalidos.add("Tercer Nombre");
        if (!isValidApellidoPaterno) camposInvalidos.add("Apellido Paterno");
        if (!isValidApellidoMaterno) camposInvalidos.add("Apellido Materno");
        if (!isValidCorreo) camposInvalidos.add("Correo");
        if (!isValidFechaNacimiento) camposInvalidos.add("Fecha de Nacimiento");
        if (!isValidRFC) camposInvalidos.add("RFC");
        if (!isValidIdEstado) camposInvalidos.add("Estado");
        if (!isValidCURP) camposInvalidos.add("CURP");
        if (!isValidEstadoCivil) camposInvalidos.add("Estado Civil");
        if (!isValidTelefono) camposInvalidos.add("Telefono");
        if (!isValidTelefonoParticular) camposInvalidos.add("Telefono Particular");
        if (!isValidObservaciones) camposInvalidos.add("Observaciones");
        if (!isValidCardNumber) camposInvalidos.add("Número de Tarjeta");

        return camposInvalidos;

        // Return true if all fields are valid, false otherwise
        /*return isValidEmpresa &&
                isValidNombre &&
                isValidSegundoNombre &&
                isValidTercerNombre &&
                isValidApellidoPaterno &&
                isValidApellidoMaterno &&
                isValidCorreo &&
                isValidFechaNacimiento &&
                isValidRFC &&
                isValidIdEstado &&
                isValidCURP &&
                isValidEstadoCivil &&
                isValidTelefono &&
                isValidTelefonoParticular &&
                //isValidObservaciones &&
                isValidCardNumber;*/
    }

    // Method to validate a field using a regular expression
    private static boolean validateField(String fieldValue, String regex) {
        return fieldValue != null && fieldValue.matches(regex);
    }
}
