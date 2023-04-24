<?php
	include 'model.php';

	if (isset($_POST['nome'])) {
		$nome = $_POST['nome'];
		if (!empty($nome))
			$mensagem = cumprimentar($nome);
	}

	header("Location: view.php?mensagem=" . $mensagem);
	
?>
