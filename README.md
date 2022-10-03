# Desafio Connect Stellantis 2022

## Projeto Car Trip Report
Uma prova de conceito, de código fonte aberto, que foi implementada utilizando a linguagem Java e combinação de bibliotecas opencsv, jcommon, jfreechar e swing. Tem por objetivo analisar os dados sensoriais dos véiculos conectados e gerar um relatório de viagem, proporcionando ao passageiro controle total sobre tudo o que ocorreu no veículo durante a viagem, como oscilação da pressão dos pneus, tensão da bateria, nível de óleo do motor, marcador de kilometragem, quantidade de combustível entre outros.

<p align="center">
  <img width="500" height="330" src="doc/img/mainscreen.png">
</p>

## Como Executar

Para executar o software é necessário que se tenha instalado a máquina virtual Java (openjdk >= 1.8) no sistema operacional.
Dentro do repositório, no diretório raíz, executar:

```
java -cp src/libs/app.jar connect.stellantis.car.trip.report.App
```

## Funcionamento

O sistema funciona realizando a leitura de dados sensoriais de uma viagem realizada por um veículo. Esses dados ficam em um arquivo com extensão csv.
Esse arquivo possui dados, em função do tempo, lidos dos sensores contidos no veículo durante a viagem do mesmo.
Os seguintes dados são utilizados pelo sistema:
- Distância percorrida reportada pelo odômetro.
- Nível de óleo no motor.
- Tensão na bateria.
- Pressão nos pneus.
- Quantidade de combustível no tanque.

## Arquitetura do Sistema

O sistema foi divido em 2 subsistemas como mostrado abaixo:

- 1-) Sistema de controle e leitura de dados (BACKEND)
- 2-) GUI - Interface gráfica com o usuário (FRONTEND)

## Funcionalidades

O sistema ainda é uma demonstração de conceito, portanto, não apresenta ainda todos as funcionalidades desejáveis.
As funcionalidades abaixo são as já implementadas na solução.
- Leitura de dados brutos de viagem.
- Exibição de relatório de viagem contendo informações do começo da viagem e do final da viagem, para se poder realizar comparações.
- Exibição em gráfico cartesiano da distância pecorrida com relação ao tempo da viagem.
- Exibição em gráfico cartesiano do nível de óleo no motor com relação ao tempo da viagem.
- Exibição em gráfico cartesiano da tensão na bateria com relação ao tempo da viagem.
- Exibição em gráfico cartesiano da pressão nos quatro pneus com relação ao tempo da viagem.
- Exibição em gráfico cartesiano da quantidade de combústivel no tanque com relação ao tempo da viagem.

## Próximos Passos

Várias ideias foram surgindo ao decorrer do projeto e não foram possíveis ainda de serem implementas por limitação de tempo.
As ideias abaixo são os próximos passos para evolução da solução apresentada por esse projeto.
- Cálculo da quantidade de kilômetros percorridos na viagem e exibição no relatório de viagem.
- Cálculo da quantidade de combústivel utilizado na viagem e exibição no relatório de viagem.
- Cálculo do preço da viagem utilizando os dados de combústivel utilizado e distância percorrida.
- Divisão do preço da viagem por passageiros no carro, facilitando rateamento de despesas.
- Verificação automática, através de inteligência artificial, de problemas com nível do óleo.
- Verificação automática, através de inteligência artificial, de pneu furado.
- Verificação automática, utilizando dados de posição e dados de distância percorrida, de velocidade excedida no trecho.
- Verificação automática, através de inteligência artificial, de problemas de rendimento no consumo de combústivel.
- Cálculo de consumo do véiculo e exportação dos dados por bluetooth, wifi, para o celular.
- Adição de dados de marcha atual do câmbio, para então realizar gráficos de consumo por marcha.

## Quer contribuir?

No momento o projeto ainda encontra-se privado pois se trato de uma solução para um desafio proposto pela empresa Stellantis.

Apesar disso, trata-se de um projeto de código aberto e qualquer contribuição será super bem vinda no futuro próximo.

As tarefas estão visíveis na sessão **_Issues_** deste repositório e outras ainda estarão sendo adicionadas. Para quem deseja contribuir, basta escolher uma tarefa e realizar o **_FORK_** do projeto e, então, mão na massa!

Estamos abertos para tirar qualquer dúvida :).
