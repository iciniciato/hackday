package br.com.invillia.model;

import java.io.Serializable;
import java.util.Objects;

public class Combustivel implements Serializable {

    private TipoCombustivel tipoCombustivel;
    private Integer quantidadeEmLitros;
    private Integer tamanhoMaximoDoTanqueDeCombustivel;

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Integer getQuantidadeEmLitros() {
        return quantidadeEmLitros;
    }

    public void setQuantidadeEmLitros(Integer quantidadeEmLitros) {
        this.quantidadeEmLitros = quantidadeEmLitros;
    }

    public Integer getTamanhoMaximoDoTanqueDeCombustivel() {
        return tamanhoMaximoDoTanqueDeCombustivel;
    }

    public void setTamanhoMaximoDoTanqueDeCombustivel(Integer tamanhoMaximoDoTanqueDeCombustivel) {
        this.tamanhoMaximoDoTanqueDeCombustivel = tamanhoMaximoDoTanqueDeCombustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combustivel that = (Combustivel) o;
        return tipoCombustivel == that.tipoCombustivel &&
                Objects.equals(quantidadeEmLitros, that.quantidadeEmLitros) &&
                Objects.equals(tamanhoMaximoDoTanqueDeCombustivel, that.tamanhoMaximoDoTanqueDeCombustivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoCombustivel, quantidadeEmLitros, tamanhoMaximoDoTanqueDeCombustivel);
    }
}
