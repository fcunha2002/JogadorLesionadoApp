<?php

//conexão com o servidor
$conect = mysqli_connect("localhost", "root", "", "jldb_des");

// Caso a conexão seja reprovada, exibe na tela uma mensagem de erro
if (!$conect) die ("<h1>Falha na conexão com o Banco de Dados!</h1>");

?>