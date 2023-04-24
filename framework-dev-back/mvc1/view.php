<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MVC</title>
</head>
<body>
	<h2>MVC: Exemplo</h2>
	<form action="controller.php" method="POST">
		<label for="nome">Digite seu nome:</label>
		<input type="text" name="nome" id="nome">
		<button type="submit">Enviar</button>
	</form>
	<?php 
		if (!empty($_GET['mensagem'])) { ?>
		<p><?php echo $_GET['mensagem']; } 
	?> </p>
		
</body>
</html>