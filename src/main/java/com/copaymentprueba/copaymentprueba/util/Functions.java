package com.copaymentprueba.copaymentprueba.util;

import java.time.Duration;
import java.time.LocalTime;

public class Functions {

    public static double obtenerSalarioDiario(LocalTime horaDeEntrada, LocalTime horaDeSalida, double tarifaPorHora) {
        //Si todavía no tiene registrada hora de salida, mandar 0.0
        if (horaDeSalida == null) return 0.0;

        // Calcula la duración entre horaDeEntrada y horaDeSalida
        Duration duration = Duration.between(horaDeEntrada, horaDeSalida);

        // Convierte la duración de horas a double
        double horas = duration.toHours(); // Total de horas enteras
        double minutos = duration.toMinutesPart() / 60.0; // Horas fraccionadas (minutos / 60)

        // Calcula el total de horas (horas enteras + fracciones de hora)
        double totalHours = horas + minutos;

        //Calcula el total de horas por la tarifa por hora de cada departamento del empleado
        return totalHours*tarifaPorHora;
    }
}
