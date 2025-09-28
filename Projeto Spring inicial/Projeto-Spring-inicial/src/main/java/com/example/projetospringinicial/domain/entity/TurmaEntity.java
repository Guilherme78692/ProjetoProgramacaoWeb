package com.example.projetospringinicial.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "turmas")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String periodo;

    @Column(nullable = false)
    private String curso;

    public TurmaEntity() {}

    public TurmaEntity(Long id, String nome, String periodo, String curso) {
        this.id = id;
        this.nome = nome;
        this.periodo = periodo;
        this.curso = curso;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
