package com.estech.abogados_bbdd.DTO;

public class AbogadoDTO {
    private String codigoColegiado;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    
    public AbogadoDTO() {

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
