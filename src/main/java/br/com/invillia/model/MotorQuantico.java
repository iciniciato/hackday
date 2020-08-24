package br.com.invillia.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MotorQuantico implements Serializable {

    private Long quantidadeSaltosQuanticosTotal;
    private List<Combustivel> combustiveisDisponiveis;
    private Double mediaDeConsumo;
    private List<String> informacaoDoMotor;
    private Integer autonomia;

    public Long getQuantidadeSaltosQuanticosTotal() {
        return quantidadeSaltosQuanticosTotal;
    }

    public void setQuantidadeSaltosQuanticosTotal(Long quantidadeSaltosQuanticosTotal) {
        this.quantidadeSaltosQuanticosTotal = quantidadeSaltosQuanticosTotal;
    }

    public List<Combustivel> getCombustiveisDisponiveis() {
        return combustiveisDisponiveis;
    }

    public void setCombustiveisDisponiveis(List<Combustivel> combustiveisDisponiveis) {
        this.combustiveisDisponiveis = combustiveisDisponiveis;
    }

    public Double getMediaDeConsumo() {
        return mediaDeConsumo;
    }

    public void setMediaDeConsumo(Double mediaDeConsumo) {
        this.mediaDeConsumo = mediaDeConsumo;
    }

    public List<String> getInformacaoDoMotor() {
        return informacaoDoMotor;
    }

    public void setInformacaoDoMotor(List<String> informacaoDoMotor) {
        this.informacaoDoMotor = informacaoDoMotor;
    }

    public Integer getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Integer autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotorQuantico that = (MotorQuantico) o;
        return Objects.equals(quantidadeSaltosQuanticosTotal, that.quantidadeSaltosQuanticosTotal) &&
                Objects.equals(combustiveisDisponiveis, that.combustiveisDisponiveis) &&
                Objects.equals(mediaDeConsumo, that.mediaDeConsumo) &&
                Objects.equals(informacaoDoMotor, that.informacaoDoMotor) &&
                Objects.equals(autonomia, that.autonomia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantidadeSaltosQuanticosTotal, combustiveisDisponiveis, mediaDeConsumo, informacaoDoMotor, autonomia);
    }

    @Override
    public String toString() {
        return "MotorQuantico{" +
                "quantidadeSaltosQuanticosTotal=" + quantidadeSaltosQuanticosTotal +
                ", combustiveisDisponiveis=" + combustiveisDisponiveis +
                ", mediaDeConsumo=" + mediaDeConsumo +
                ", informacaoDoMotor=" + informacaoDoMotor +
                ", autonomia=" + autonomia +
                '}';
    }
}
