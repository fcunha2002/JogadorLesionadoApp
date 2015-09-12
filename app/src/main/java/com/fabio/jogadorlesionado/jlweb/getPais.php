<?php
header('Content-type: application/json');

include "conecta.php";

$sqlCommand = "SELECT * FROM pais";
$query = mysqli_query($conect, $sqlCommand);

$dados = array();

while ($row = mysqli_fetch_assoc($query)){
    $dados[] = array("dados"=>$row);
}

echo json_encode(array("paises"=>$dados));

?>