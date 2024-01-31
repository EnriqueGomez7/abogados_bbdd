package com.estech.abogados_bbdd.DTO;

public class ClienteDTO {
    
    private String nombreCliente;
    private String apellidoCliente;
    private AbogadoDTO abogado;
    
    public ClienteDTO() {
    }

    public ClienteDTO(String nombreCliente, String apellidoCliente, AbogadoDTO abogado) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.abogado = abogado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public AbogadoDTO getAbogado() {
        return abogado;
    }

    public void setAbogado(AbogadoDTO abogado) {
        this.abogado = abogado;
    }

    
    
    
    

}
