## Expotec 2024

### Ideia:
Criar um minijogo de "caça ao tesouro" no jogo Minecraft envolvendo Arduino, mostrando led se está perto.

No inicio abrirá a página de edição de itens da bigorna
e tera um texto em cima dizendo ("Digite seu nome para entrar no ranking")
e uma seta insinuando para clicar no item após renomear, após isso.
Será dado o item de uma PÁ para o jogador no inicio, o jogador será teleportado pra uma mini arena (40x40), o jogador deverá usar os leds do arduino como uma bússula e terá o objetivo cavar e de encontrar o baú (tesouro)
que ao encontrar a arena será resetada, baú será definido e outra região
~~terá cerca de 5 minutos, quem encontrar mais baús será registrado na Scoreboard/Leaderboard.~~
O Jogador terá que bater o recorde dos jogadores na lista do ranking, não podendo passar do tempo máximo. (30° jogador da lista do ranking)

Arduino possuindo 3 leds, vermelho, laranja e verde
vermelho: longe
laranja: que está quase perto
verde: que pode estar ao redor do jogador
(Se o jogador estiver muito perto piscar todas os leds)


## Arduino + Sketch

[projeto](https://www.tinkercad.com/things/4CsAqzCUjmf-expotec-minecraft-2024?sharecode=N_ip5fn6wPsz_1O8KaItVAOZYmll_KhuWK5MK8uHq5U)

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


## Librarys/Frameworks Used:

* [Spigot (Minecraft Server)](https://www.spigotmc.org/wiki/spigot-plugin-development/)

* [DecentHolograms](https://github.com/DecentSoftware-eu/DecentHolograms)

* [SignGUI](https://github.com/Rapha149/SignGUI)

* [ProtocolLib](https://github.com/dmulloy2/ProtocolLib)

* [Images](https://github.com/Andavin/Images)
