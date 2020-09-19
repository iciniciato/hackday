package br.com.invillia.model;

import java.io.Serializable;

public enum TipoCombustivel implements Serializable {
    CRISTAL_DE_ENERGIA_LIQUIDO(0.45),
    COMBUSTIVEL_FOGUETE(20);

    private double peso;

    TipoCombustivel(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
