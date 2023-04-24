<?php 
    include 'model.php';

    if(isset($_POST['numeros'])){
        $numeros = $_POST['numeros'];
        $aux = "";

        for ($i=0; $i < strlen($numeros); $i++) { 
            if($numeros[$i] == "+" || $numeros[$i] == "-" || $numeros[$i] == "/" || $numeros[$i] == "*"){
                $operacao = $numeros[$i];
                $primeiroNumero = $aux;
                $aux = "";
            }else{
                $aux = $aux . "". $numeros[$i];
            }
        }

        var_dump($aux);

        $calculadora = new Calculadora();

        

        switch ($operacao) {
            case '+':
                $resultado = $calculadora->somar(intval($primeiroNumero), intval($aux));
                
                break;
            case '-':
                $resultado = $calculadora->subtrair(intval($primeiroNumero), intval($aux));
                break;
            case '*':
                $resultado = $calculadora->multiplicar(intval($primeiroNumero), intval($aux));
                break;
            case '/':
                $resultado = $calculadora->dividir(intval($primeiroNumero), intval($aux));
                break;
            default:
                break;
        }


        header("Location: index.php?resultado=" . $resultado);

    }


?>