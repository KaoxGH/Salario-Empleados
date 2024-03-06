package com.copaymentprueba.copaymentprueba.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "excel_usuarios")
public class ExcelUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "tercer_nombre")
    private String tercerNombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaDeNacimiento;

    @Column(name = "rfc", nullable = false, unique = true)
    private String rfc;

    @Column(name = "id_estado", nullable = false)
    private String idEstado;

    @Column(name = "curp", nullable = false, unique = true)
    private String curp;

    @Column(name = "estado_civil", nullable = false)
    private String estadoCivil;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "telefono_particular")
    private String telefonoParticular;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;
}
