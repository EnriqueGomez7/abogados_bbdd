package com.estech.abogados_bbdd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "abogados")
public class Abogado {
    
    @Id
    private String codigoColegiado;

    private String nombre;

    private String apellidoUno;

    private String apellidoDos;

    public Abogado() {
    }

    public Abogado(String codigoColegiado, String nombre, String apellidoUno, String apellidoDos) {
        this.codigoColegiado = codigoColegiado;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
    }

    public String getCodigoColegiado() {
        return codigoColegiado;
    }

    public void setCodigoColegiado(String codigoColegiado) {
        this.codigoColegiado = codigoColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    

}
