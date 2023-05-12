package br.com.ruannarici.principal;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.ruannarici.modelo.Partida;
import br.com.ruannarici.modelo.Time;
import br.com.ruannarici.servico.ArquivoServico;

public class iniciar {
	
	private static ArquivoServico arquivo = new ArquivoServico();
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		Boolean continuar = true;
		
		System.out.println("Digite o caminho e nome do arquivo: ");
		String nomeArquivo = scan.next();
		
		String texto = arquivo.ler(nomeArquivo);
		
		System.out.println("## Digite uma opcao valida ##");
		
		while (continuar) {
			System.out.println("0 - SAIR");
			System.out.println("1 - EXIBIR O MELHOR TIME DO NBB");
			System.out.println("2 - EXIBIR O PRIMEIRO E SEGUNDO MELHOR TIME DO NBB");
			System.out.println("3 - EXIBIR O RANK COMPLETO");
			System.out.println("4 - EXIBIR TODAS AS PARTIDAS");
			
			Integer opcao = scan.nextInt();
			
			switch (opcao) {
			case 1: {
				List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
				Time[] arrayTimeUm = listaDeTimes.get(0);
				Time[] arrayTimeDois = listaDeTimes.get(1);
				
				Map<String, Time> rankList = arquivo.toRankList(arrayTimeUm, arrayTimeDois);
				
				System.out.println(System.lineSeparator() + "#-> RESULTADO");
				rankList.entrySet().stream()
				.sorted(Map.Entry.<String, Time>comparingByValue((o1, o2) -> o1.getPontos().compareTo(o2.getPontos()))
						.reversed()) 
		        .limit(1) 
		        .forEach(System.out::println); 
				System.out.println();
				break;
			}
			case 2: {
				List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
				Time[] arrayTimeUm = listaDeTimes.get(0);
				Time[] arrayTimeDois = listaDeTimes.get(1);
				
				Map<String, Time> rankList = arquivo.toRankList(arrayTimeUm, arrayTimeDois);
				
				System.out.println(System.lineSeparator() + "#-> RESULTADO");
				rankList.entrySet().stream()
				.sorted(Map.Entry.<String, Time>comparingByValue((o1, o2) -> o1.getPontos().compareTo(o2.getPontos()))
						.reversed()) 
		        .limit(2) 
		        .forEach(System.out::println); 
				System.out.println();
				break;
			}
			case 3: {
				List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
				Time[] arrayTimeUm = listaDeTimes.get(0);
				Time[] arrayTimeDois = listaDeTimes.get(1);
				
				Map<String, Time> rankList = (LinkedHashMap<String, Time>) arquivo.toRankList(arrayTimeUm, arrayTimeDois);
				
				System.out.println(System.lineSeparator() + "#-> RESULTADO");
				rankList.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(
						Comparator.comparing(Time::getPontos)
						.thenComparing(Time::getPlacar)
						.reversed()))
				.forEach(System.out::println);;
				System.out.println();
				break;
			}
			case 4: {
				List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
				Time[] arrayTimeUm = listaDeTimes.get(0);
				Time[] arrayTimeDois = listaDeTimes.get(1);
				
				List<Partida> listaDePartidas = arquivo.toListPartida(texto, arrayTimeUm, arrayTimeDois);
				
				System.out.println(System.lineSeparator() + "#-> RESULTADO");
				listaDePartidas.forEach(System.out::println);
				System.out.println();
				break;
			}
			default: {
				continuar = false; 
				System.out.println("Processo finalizado");
				break;
			}
			}
		}
		
	}

}
