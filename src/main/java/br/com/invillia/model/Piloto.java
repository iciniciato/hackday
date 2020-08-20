package br.com.invillia.model;

import java.io.Serializable;
import java.util.Objects;

public class Piloto implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private Patente patente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(id, piloto.id) &&
                Objects.equals(nome, piloto.nome) &&
                Objects.equals(email, piloto.email) &&
                Objects.equals(patente, piloto.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, patente);
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", patente=" + patente +
                '}';
    }
}
