package ejemplo_java_bbdd;

import java.sql.Date;

public class vehiculo {
    private int id;
    private String tipo;
    private String marca;
    private int potencia;
    private Date fechaDeCompra;

    // Costruttore
    public vehiculo(int id, String tipo, String marca, int potencia, Date fechaDeCompra) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaDeCompra = fechaDeCompra;
    }

    // Metodi getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    // Metodo toString per stampare i dettagli del veicolo
    @Override
    public String toString() {
        return "vehiculo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", potencia=" + potencia +
                ", fechaDeCompra=" + fechaDeCompra +
                '}';
    }
}
