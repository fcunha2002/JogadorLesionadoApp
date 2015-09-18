<?php
header('Content-type: application/json');

include "conecta.php";
include "funcoes.php";

mysqli_query($conect, 'SET CHARACTER SET utf-8');


if (isset($_POST['dt_atualizacao'])){
    $data = $_POST['dt_atualizacao'];
    $sqlCommand = "SELECT * FROM clube where dt_atualizacao>='".$data."';";
}else{
    $sqlCommand = "SELECT * FROM clube;";
}

$query = mysqli_query($conect, $sqlCommand);

$dados = array();

while ($row = mysqli_fetch_assoc($query)){
    array_walk($row, 'toUtf8');
    $dados[] = array("dados"=>$row);
}

echo json_encode(array("clubes"=>$dados));

?>