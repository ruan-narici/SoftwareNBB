<!-- Inserir imagem com a #vitrinedev ao final do link -->
![Ruan Narici](./assets/img/preview.gif#vitrinedev)

``` 
> Status 

✅ **Finalizado!**

```

## Desafio
Supondo que você tenha uma empresa de software, e que o NBB contrate sua empresa para escrever
um programa que informe, automaticamente, quem são os primeiros k times dessa competição. Seu
programa deve ler o arquivo de entrada uma ÚNICA vez, e a ordenação desses times é determinada
a partir do número de vitórias obtidas, e caso os times tenham o mesmo número de vitórias, o
critério de desempate é o número de pontos. Os dados de entrada são as datas, os horários, os times
e os placares dos jogos. O usuário deve digitar o nome do arquivo e selecionar uma das opções:
* Exibir o melhor time do NBB
* Exibir o melhor e o vice times da competição. 

## Detalhes do projeto
O projeto visa tratar os dados armazenados em um arquivo **.txt**. 
Após o tratamento dos dados o programa cria objetos e insere neles os seus respectivos atributos (nome do time, pontos do time, placar do time, data e hora da partida e a partida entre os times com todos os dados).

```
~ O arquivo **.txt** deve está com o seguinte formato:
String/String/String/Integer/Integer
Data e Hora/Nome do primeiro time/Nome do segundo time/Placar do primeiro time/Placar do segundo time
ex:
00.00. 00:00/Time1/Time2/00/00
```

## Funcionalidades
Com todos os dados tratados, o programa permite ao usuário ter acesso a algumas informações como: 
* Listar todas as partidas;
* Rank completo;
* Exibir campeão e o vice-campeão;
* Exibir o campeão. 