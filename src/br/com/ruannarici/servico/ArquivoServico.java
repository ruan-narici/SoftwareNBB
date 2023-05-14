package br.com.ruannarici.servico;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.ruannarici.modelo.Partida;
import br.com.ruannarici.modelo.Time;

public class ArquivoServico {
	
	public String ler(String arquivo) throws IOException {
		
		FileInputStream fis = new FileInputStream(arquivo + ".txt");
		InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(isr);
		
		String texto = br.readLine() + "/" + System.lineSeparator();
		
		while(br.ready()) {
			texto += br.readLine() + "/" + System.lineSeparator();
		}
		
		br.close();
		return texto;
	}
	
	public List<Time[]> toArrayTimes(String texto) {
		
		String[] timeSeparado = texto.split("/");
		Integer contador = 0;
		
		Time arrayTimeUm[] = new Time[(timeSeparado.length / 5) + 1];
		Time arrayTimeDois[] = new Time[(timeSeparado.length / 5) + 1];
		
		for (int i = 0; i < timeSeparado.length - 1; i += 5) {
			Time timeUm = new Time();
			Time timeDois = new Time();
			
			timeUm.setNome(timeSeparado[i + 1]);
			timeDois.setNome(timeSeparado[i + 2]);
			timeUm.setPlacar(Integer.parseInt(timeSeparado[i + 3]));
			timeDois.setPlacar(Integer.parseInt(timeSeparado[i + 4]));
			
			if (timeUm.getPlacar() > timeDois.getPlacar()) {
				timeUm.pontuar();
			} else {
				timeDois.pontuar();
			}

			arrayTimeUm[contador] = timeUm;
			arrayTimeDois[contador] = timeDois;
			contador++;

		}
		
		List<Time[]> listaDeTimes =  new ArrayList<>();
		listaDeTimes.add(arrayTimeUm);
		listaDeTimes.add(arrayTimeDois);
		return listaDeTimes;
	}
	
	public List<Partida> toListPartida(String texto, Time[] listaTimeUm, Time[] listaTimeDois) {
		
		String[] timeSeparado = texto.split("/");
		Integer contador = 0;
		
		List<Partida> listaPartida = new ArrayList<>();
		
		for (int i = 0; i < timeSeparado.length - 1; i += 5) {
			
			Partida partida = new Partida();
			Time timeUm = listaTimeUm[contador];
			Time timeDois = listaTimeDois[contador];
			contador++;
			
			partida.setDataHora(timeSeparado[i]);
			partida.setTimeUm(timeUm);
			partida.setPlacarTimeUm(timeUm.getPlacar());
			partida.setTimeDois(timeDois);
			partida.setPlacarTimeDois(timeDois.getPlacar());
			
			listaPartida.add(partida);
		}
		
		return listaPartida;
	}
	
	public Map<String, Time> toRankList(Time[] listaTimeUm, Time[] listaTimeDois) {
		Map<String, Time> rankList = new LinkedHashMap<>();
		
		for (int i = 0; i < listaTimeUm.length - 1; i++) {
			
			if (!rankList.containsKey(listaTimeUm[i].getNome())) {
				rankList.put(listaTimeUm[i].getNome(), listaTimeUm[i]);
			} else {
				listaTimeUm[i].setPlacar( 
						listaTimeUm[i].getPlacar() + rankList.get(
								listaTimeUm[i].getNome()
								).getPlacar()
						);
				listaTimeUm[i].setPontos(
						listaTimeUm[i].getPontos() + rankList.get(
								listaTimeUm[i].getNome()
								).getPontos()
						);
				rankList.put(listaTimeUm[i].getNome(), listaTimeUm[i]);
			}
			if (!rankList.containsKey(listaTimeDois[i].getNome())) {
				rankList.put(listaTimeDois[i].getNome(), listaTimeDois[i]);
			} else {
				listaTimeDois[i].setPlacar( 
						listaTimeDois[i].getPlacar() + rankList.get(
								listaTimeDois[i].getNome()
								).getPlacar()
						);
				listaTimeDois[i].setPontos(
						listaTimeDois[i].getPontos() + rankList.get(
								listaTimeDois[i].getNome()
								).getPontos()
						);
				rankList.put(listaTimeDois[i].getNome(), listaTimeDois[i]);
			}
		}
		return rankList;
	}

}
