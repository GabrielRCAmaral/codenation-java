package br.com.codenation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private final Long id;
    private final String nome;
    private final LocalDate dataCriacao;
    private final String corUniformePrimario;
    private final String corUniformeSecudario;
    private Long capitao;
    private final List<Jogador> jogadores = new ArrayList<>();

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
        this.id=id;
        this.nome=nome;
        this.dataCriacao=dataCriacao;
        this.corUniformePrimario=corUniformePrincipal;
        this.corUniformeSecudario=corUniformeSecundario;
        this.capitao= new Long(0);

    }

    public Long getId(){
        return this.id;
    }
    public void setCapitao(Long capitao){
        this.capitao=capitao;
    }

    public Long getCapitao(){
        return this.capitao;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCorUniformePrimario(){
        return this.corUniformePrimario;
    }

    public String getCorUniformeSecudario(){
        return this.corUniformeSecudario;
    }

    public void addJogador(Jogador jogador){
        jogadores.add(jogador);
    }

    public List<Jogador> getJogadores(){
        return this.jogadores;
    }
}
