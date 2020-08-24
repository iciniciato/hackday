package br.com.invillia.model;

import java.io.Serializable;

public class PilotoAuto implements Serializable {

    private Boolean ligar = false;

    private static PilotoAuto instancia;

    public static PilotoAuto getInstancia() {
        if (instancia == null) instancia = new PilotoAuto();
        return instancia;
    }

    public Boolean getLigar() {
        return ligar;
    }

    public void setLigar(Boolean ligar) {
        this.ligar = ligar;
    }

    @Override
    public String toString() {
        return "PilotoAuto{" +
                "ligar=" + ligar +
                '}';
    }
}
