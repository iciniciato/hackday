package br.com.invillia.model;

import java.io.Serializable;
import java.util.Objects;

public class Nave implements Serializable {
    public final int PESO_MAXIMO_EM_KG = 5060;

    private MotorQuantico motorQuantico;
    private String nome;
    private Long codigo;

    public MotorQuantico getMotorQuantico() {
        return motorQuantico;
    }

    public void setMotorQuantico(MotorQuantico motorQuantico) {
        this.motorQuantico = motorQuantico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nave nave = (Nave) o;
        return Objects.equals(motorQuantico, nave.motorQuantico) &&
                Objects.equals(nome, nave.nome) &&
                Objects.equals(codigo, nave.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorQuantico, nome, codigo);
    }

    @Override
    public String toString() {
        return "Nave{" +
                "motorQuantico=" + motorQuantico +
                ", nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
