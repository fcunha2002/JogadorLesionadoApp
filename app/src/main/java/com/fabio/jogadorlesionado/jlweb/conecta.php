<?php

//conex�o com o servidor
$conect = mysqli_connect("localhost", "root", "", "jldb_des");

// Caso a conex�o seja reprovada, exibe na tela uma mensagem de erro
if (!$conect) die ("<h1>Falha na conex�o com o Banco de Dados!</h1>");

?>