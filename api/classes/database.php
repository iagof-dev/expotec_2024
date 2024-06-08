<?php
class db{

    private $host;
    private $port;
    private $user;
    private $pass;
    private $db;

    function __construct()
    {
        $this->host = 'marciossupiais.shop';
        $this->port = '3306';
        $this->user = 'n3rdydev';
        $this->pass = 'N3rdygamerbr@123';
    }

    function getConnection(){
        $db = new PDO("mysql:host=$this->host:$this->port;dbname=expotec;charset=UTF8", $this->user, $this->pass);
        return $db;
    }

    function query($sql){
        try {
            $rs = $this->getConnection()->prepare($sql);
            $rs->execute();
            $numRowsAffected = $rs->rowCount();
            if ($numRowsAffected > 0) {
                return ['status' => 'success', 'DATA' => $rs->fetchAll(PDO::FETCH_ASSOC)];
            } else {
                return ['status'=> 'error', 'message' => 'Nenhum registro encontrado'];
            }
        } catch (Exception $ex) {
            return ['status'=> 'error', 'message' => $ex->getMessage()];
        }
    }

    function insert($sql){
        try {
            $rs = $this->getConnection()->prepare($sql);
            $rs->execute();
            $numRowsAffected = $rs->rowCount();
            return ['status' => 'success', 'message' => 'Registro inserido com sucesso', 'rows' => $numRowsAffected];

        } catch (Exception $ex) {
            return ['status'=> 'error', 'message' => $ex->getMessage()];
        }
    }

}