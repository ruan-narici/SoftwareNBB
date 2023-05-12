package br.com.ruannarici.modelo;

public class Time {

	private String nome;
	private Integer placar;
	private Integer pontos;

	public Time() {
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPlacar() {
		return placar;
	}

	public void setPlacar(Integer placar) {
		this.placar = placar;
	}

	public Integer getPontos() {
		return pontos;
	}
	
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public void pontuar() {
		this.pontos++;
	}
	
	@Override
	public String toString() {
		return "PLACAR: " + this.placar + ", PONTOS: " + this.pontos;
	}

}
