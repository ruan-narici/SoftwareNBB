package br.com.ruannarici.principal;

import java.io.IOException;
import java.util.Comparator;
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
				exibirRank(texto, 1);
				break;
			}
			case 2: {
				exibirRank(texto, 2);
				break;
			}
			case 3: {
				exibirRank(texto, 999);
				break;
			}
			case 4: {
				exibirPartidas(texto);
				break;
			}
			default: {
				continuar = false; 
				System.out.println("Processo finalizado");
				break;
			}
			}
		}
		
		scan.close();
		
	}
	
	public static void exibirRank(String texto, Integer topTimes) {
		List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
		Time[] arrayTimeUm = listaDeTimes.get(0);
		Time[] arrayTimeDois = listaDeTimes.get(1);
		
		Map<String, Time> rankList = arquivo.toRankList(arrayTimeUm, arrayTimeDois);
		
		System.out.println(System.lineSeparator() + "#-> RESULTADO");
		rankList.entrySet().stream()
		//Aqui ele ordena com base no 
		.sorted(Map.Entry.comparingByValue(
				//Primeiro parametro (principal)
				Comparator.comparing(Time::getPontos)
				//Secundo parametro (secundario)
				.thenComparing(Time::getPlacar)
				//Descendente
				.reversed()))
		.limit(topTimes)
		//Imprimindo cada um dos itens dentro do LinkedHashMap
		//Será impresso uma lista ordenada pelo maior ponto e maior placar
		.forEach(System.out::println);
		System.out.println();
	}
	
	public static void exibirPartidas(String texto) {
		List<Time[]> listaDeTimes = arquivo.toArrayTimes(texto);
		Time[] arrayTimeUm = listaDeTimes.get(0);
		Time[] arrayTimeDois = listaDeTimes.get(1);
		
		List<Partida> listaDePartidas = arquivo.toListPartida(texto, arrayTimeUm, arrayTimeDois);
		
		System.out.println(System.lineSeparator() + "#-> RESULTADO");
		listaDePartidas.forEach(System.out::println);
		System.out.println();
	}

}
