package com.invillia.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "membros")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_membro",nullable = false)
    private String nome_membro;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_time", nullable = false)
    private Team team;

    public Member(String nome_membro, Team team) {
        this.nome_membro = nome_membro;
        this.team = team;
    }

    public Member() {
    }

    @Override
    public String toString() {
        return "Member "+ id + ", " + nome_membro + ", "+ team;
    }
}
