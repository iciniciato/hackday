package br.com.invillia.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Rota implements Serializable {

    private String pontoDeOrigem;
    private List<String> destinos;
    private Integer totalDeSaltosNecessarios;

    public String getPontoDeOrigem() {
        return pontoDeOrigem;
    }

    public void setPontoDeOrigem(String pontoDeOrigem) {
        this.pontoDeOrigem = pontoDeOrigem;
    }

    public List<String> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<String> destinos) {
        this.destinos = destinos;
    }

    public Integer getTotalDeSaltosNecessarios() {
        return totalDeSaltosNecessarios;
    }

    public void setTotalDeSaltosNecessarios(Integer totalDeSaltosNecessarios) {
        this.totalDeSaltosNecessarios = totalDeSaltosNecessarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rota rota = (Rota) o;
        return Objects.equals(pontoDeOrigem, rota.pontoDeOrigem) &&
                Objects.equals(destinos, rota.destinos) &&
                Objects.equals(totalDeSaltosNecessarios, rota.totalDeSaltosNecessarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pontoDeOrigem, destinos, totalDeSaltosNecessarios);
    }

    @Override
    public String toString() {
        return "Rota{" +
                "pontoDeOrigem='" + pontoDeOrigem + '\'' +
                ", destinos=" + destinos +
                ", totalDeSaltosNecessarios=" + totalDeSaltosNecessarios +
                '}';
    }
}
