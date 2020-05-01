package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    private final Long id;
    private final Long idTime;
    private final String nome;
    private final LocalDate dataNascimento;
    private final Integer nivelHabilidade;
    private final BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario){
        this.id=id;
        this.idTime=idTime;
        this.nome =nome;
        this.dataNascimento=dataNascimento;
        this.nivelHabilidade=nivelHabilidade;
        this.salario=salario;
    }

    public Long getId(){
        return this.id;
    }
    public Long getIdTime(){
        return this.idTime;
    }
    public String getNome(){
        return this.nome;
    }
    public Integer getNivelHabilidade(){
        return this.nivelHabilidade;
    }
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    public BigDecimal getSalario(){
        return this.salario;
    }
}
