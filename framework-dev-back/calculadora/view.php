<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
    <link rel="stylesheet" href="style.css">
    
</head>
<body>
<div class="container">
  <h1>Calculadora</h1>
  <form action="controller.php" method="POST">
    <div class="form">
    <input type="text" name="numeros">
    <button type="submit">Calcular</button>
    </div>
  </form>
    <div class="resultado">
    <?php 
		if (!empty($_GET['resultado'])) { ?>
		<p><?php echo "Resultado: ". $_GET['resultado']; } 
	?> </p>
    </div>
</div>

</body>
</html>