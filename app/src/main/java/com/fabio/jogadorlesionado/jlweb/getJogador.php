<?php
header('Content-type: application/json');

include "conecta.php";
include "funcoes.php";

mysql_query('SET CHARACTER SET utf-8');
$sqlCommand = "SELECT * FROM jogador";

$query = mysqli_query($conect, $sqlCommand);

$dados = array();

while ($row = mysqli_fetch_assoc($query)){
    array_walk($row, 'toUtf8');
    $dados[] = array("dados"=>$row);
}

echo json_encode(array("jogadores"=>$dados));

?>