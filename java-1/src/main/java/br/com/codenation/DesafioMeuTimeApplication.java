package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();


	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscaTimeId(id) != null) {
			throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();

		}
		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (buscaTimeId(idTime) == null) {
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		if (buscaJogadorId(id) != null) {
			throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();
		}

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadores.add(jogador);
		buscaTimeId(idTime).addJogador(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscaJogadorId(idJogador);
		if (jogador == null) {
			throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
		}
		Time time = buscaTimeId(jogador.getIdTime());
		time.setCapitao(jogador.getId());
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscaTimeId(idTime);
		if (time == null) {
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		if (time.getCapitao() == 0) {

			throw new br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException();
		}
		return time.getCapitao();

	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscaJogadorId(idJogador);
		if (jogador == null) {
			throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();

		}
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = buscaTimeId(idTime);
		if (time == null) {
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}

		return time.getNome();
	}



	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = buscaTimeId(idTime);
		if(time==null){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		return time.getJogadores().stream().sorted(Comparator.comparing(Jogador::getId)).map(x -> x.getId()).collect(Collectors.toList()) ;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = buscaTimeId(idTime);
		if(time==null){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();

		}
		List<Jogador> jogador= time.getJogadores();
		return jogador.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId)).collect(Collectors.toList()).get(0).getId();

	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = buscaTimeId(idTime);
		if(time==null){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();

		}
		List<Jogador> jogador= time.getJogadores();

		return jogador.stream().sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId)).collect(Collectors.toList()).get(0).getId();

	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		return times.stream().sorted( Comparator.comparing(Time::getId)).map(t ->t.getId()).collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscaTimeId(idTime);
		if(time==null){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();

		}
		List<Jogador> jogador= time.getJogadores();
		return jogador.stream().sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId)).collect(Collectors.toList()).get(0).getId();

	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = buscaJogadorId(idJogador);
		if(jogador==null){
			throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
		}
		return jogador.getSalario();

	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> tops = jogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().
				thenComparing(Jogador::getId)).limit(top).map(x -> x.getId())
				.collect(Collectors.toList());
		return tops;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa=buscaTimeId(timeDaCasa);
		Time timeFora=buscaTimeId(timeDeFora);

		if(timeCasa==null)
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		if(timeFora==null)
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		if(timeCasa.getCorUniformePrimario().equals(timeFora.getCorUniformePrimario())){
			return timeFora.getCorUniformeSecudario();
		}
		return timeFora.getCorUniformePrimario();
	}

	private Time buscaTimeId(Long id) {

		return times.stream().filter(x ->x.getId().equals(id)).findAny().orElse(null);
	}

	private Jogador buscaJogadorId(Long id) {

		return jogadores.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
	}


}
