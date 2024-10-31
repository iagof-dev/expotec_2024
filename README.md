## Expotec 2024

[![wakatime](https://wakatime.com/badge/user/018e1f5e-85ee-4d1b-9e0e-ed450cf40324/project/018eab55-09b9-4255-b234-bf2df9b23354.svg)](https://wakatime.com/badge/user/018e1f5e-85ee-4d1b-9e0e-ed450cf40324/project/018eab55-09b9-4255-b234-bf2df9b23354)

### Ideia:
Criar um modo de jogo de "caça ao tesouro" no jogo Minecraft envolvendo Arduino, mostrando led se está perto.

No inicio abrirá a página de edição ~~de itens da bigorna~~ de texto da placa
e terá um texto em cima dizendo ("Digite seu nome para entrar no ranking")
~~e uma seta insinuando para clicar no item após renomear, após isso.~~
Será dado o item de uma PÁ para o jogador no inicio, o jogador será teleportado pra uma mini arena (40x40), o jogador deverá usar os leds do arduino como uma bússula e terá o objetivo cavar e de encontrar o baú (tesouro)
que ao encontrar a arena será resetada, baú será definido e outra região
O Jogador terá que bater o recorde dos jogadores na lista do ranking, não podendo passar do tempo máximo. (os 10 primeiros jogadores da lista do ranking)

Arduino possuindo 3 leds, vermelho, laranja e verde
vermelho: longe
laranja: que está quase perto
verde: que pode estar ao redor do jogador
(Se o jogador estiver muito perto piscar todas os leds)


## Arduino + Sketch

[TinkerCad Project](https://www.tinkercad.com/things/4CsAqzCUjmf-expotec-minecraft-2024?sharecode=N_ip5fn6wPsz_1O8KaItVAOZYmll_KhuWK5MK8uHq5U)

## Configurações

```
arduino:
  port: COM1
api:
  enable: false
  url: http://localhost:80/
mysql:
  enable: false
  address: 127.0.0.1
  user: root
  pass: '123'
  port: 3306
  database: N3rdyTesouro
  table: Jogadores

```

## Problemas

- Quando a opção API está desativada, as funções dela continuam sendo rodadas. (Ou seja API sendo obrigatória)

- Parte do calculo e consultas da API não estão 100% controladas, então ser der erro o plugin para de funcionar inteiro


## Librarys/Frameworks Used:

* [Spigot (NMS/Minecraft Server)](https://www.spigotmc.org/wiki/spigot-plugin-development/)

* [DecentHolograms](https://github.com/DecentSoftware-eu/DecentHolograms)

* [SignGUI](https://github.com/Rapha149/SignGUI)

* [ProtocolLib](https://github.com/dmulloy2/ProtocolLib)

* [Images](https://github.com/Andavin/Images)

* [FastBoard](https://github.com/MrMicky-FR/FastBoard)
