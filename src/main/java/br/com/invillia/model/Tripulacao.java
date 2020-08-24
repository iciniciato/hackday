package br.com.invillia.model;

import java.io.Serializable;
import java.util.Objects;

public class Tripulacao implements Serializable {

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    private int peso;

    @Override
    public String toString() {
        return "Tripulacao{" +
                "peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tripulacao that = (Tripulacao) o;
        return peso == that.peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso);
    }

}
