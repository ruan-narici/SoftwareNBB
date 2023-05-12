package br.com.ruannarici.modelo;

public class Partida {

	private String dataHora;
	private Time timeUm;
	private Integer placarTimeUm;
	private Time timeDois;
	private Integer placarTimeDois;

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public Time getTimeUm() {
		return timeUm;
	}

	public void setTimeUm(Time timeUm) {
		this.timeUm = timeUm;
	}

	public Integer getPlacarTimeUm() {
		return placarTimeUm;
	}

	public void setPlacarTimeUm(Integer placarTimeUm) {
		this.placarTimeUm = placarTimeUm;
	}

	public Time getTimeDois() {
		return timeDois;
	}

	public void setTimeDois(Time timeDois) {
		this.timeDois = timeDois;
	}

	public Integer getPlacarTimeDois() {
		return placarTimeDois;
	}

	public void setPlacarTimeDois(Integer placarTimeDois) {
		this.placarTimeDois = placarTimeDois;
	}
	
	@Override
	public String toString() {
		return this.dataHora + " " + this.timeUm.getNome() + "(" + this.timeUm.getPlacar() + ")  x  "
				+ "(" + this.timeDois.getPlacar() + ")" + this.timeDois.getNome();
				
//				+ System.lineSeparator() + "           Time 1: " + this.timeUm.getPontos() + " x " 
//				+ this.timeDois.getPontos() + " :2 Time" + System.lineSeparator();
				
	}

}
