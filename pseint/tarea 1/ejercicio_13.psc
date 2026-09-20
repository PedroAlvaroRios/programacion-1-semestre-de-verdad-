Algoritmo ejercicio_13
	Definir num_impar Como Entero
	Escribir 'introduzca dos numeros enteros'
	Leer a
	Leer b
	a_dividido <- a MOD 2
	b_dividido <- b MOD 2
	Si a_dividido=0 Entonces
		num_impar <- num_impar
	SiNo
		num_impar <- num_impar+1
	FinSi
	Si b_dividido=0 Entonces
		num_impar <- num_impar
	SiNo
		num_impar <- num_impar+1
	FinSi
	Escribir 'la cantidad de numeros impares es igual a: ', num_impar
FinAlgoritmo
