<?php

//conexão com o servidor
$conect = mysqli_connect("mysql.hostinger.com.br", "u567076667_u01", "jldbdes", "u567076667_jldbd");

// Caso a conexão seja reprovada, exibe na tela uma mensagem de erro
if (!$conect) die ("<h1>Falha na conexão com o Banco de Dados!</h1>");

?>