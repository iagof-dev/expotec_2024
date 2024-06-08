<?php
require (__DIR__ . '/../vendor/autoload.php');
require (__DIR__ . '/../classes/database.php');


use Pecee\SimpleRouter\SimpleRouter as Router;


Router::get('/', function() {
    echo(json_encode(['status' => 'success', 'message' => 'Sem parâmetros']));
    die();
});

Router::get('/listar', function() {
    $database = new db();
    $result = $database->query('SELECT * from players;');
    echo(json_encode($result));
    die();
});
Router::get('/listar/ranking', function() {
    $database = new db();
    $result = $database->query('SELECT * FROM players order by time_per_round asc;');
    echo(json_encode($result));
    die();
});

Router::get('/listar/top', function() {
    $database = new db();
    $result = $database->query('SELECT * FROM players order by time_per_round asc LIMIT 1;');
    echo(json_encode($result));
    die();
});
Router::post('/inserir/', function() {
    $database = new db();

    if(!isset($_POST) || empty($_POST['name']) || empty($_POST['time_per_round']) || empty($_POST['time_per_game'])){
        echo(json_encode(['status' => 'error', 'message' => 'Nenhum dado enviado']));
        die();
    }

    $nome = $_POST['name'];
    $time_per_round = $_POST['time_per_round'];
    $time_per_game = $_POST['time_per_game'];
    $result = $database->insert('INSERT INTO players (name, time_per_round, time_per_game) VALUES ("'. $nome .'", "'.$time_per_round.'", "'.$time_per_game.'");');
    echo(json_encode($result)); 
    die();
});

Router::error(function() {
    echo(json_encode(['status' => 'error', 'message' => 'Método ou rota não encontrada']));
    die();
});

Router::start();