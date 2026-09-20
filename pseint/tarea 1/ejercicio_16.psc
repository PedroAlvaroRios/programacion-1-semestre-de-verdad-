Algoritmo ejercicio_16
	Definir n1, n2, n3 Como entero
	
	Escribir "ingrese 3 numeros concecutivos"
	
	Escribir "Ingrese primer número:"
	Leer n1
	Escribir "Ingrese segundo número:"
	Leer n2
	
	n3 <- 0
	
	Mientras NO ((n2 = n1 + 1 Y n3 = n2 + 1) O (n2 = n1 - 1 Y n3 = n2 - 1)) Hacer
		Escribir "Ingrese el siguiente número:"
		Leer n3
		
		Si NO ((n2 = n1 + 1 Y n3 = n2 + 1) O (n2 = n1 - 1 Y n3 = n2 - 1)) Entonces
			n1 <- n2
			n2 <- n3
			Escribir "Intente de nuevo."
		FinSi
		
	Fin Mientras
	
	Escribir "Gracias"
FinAlgoritmo

//nota: el <- es lo mismo que poner un igual que (=) pero <- se utiliza mas como para Definir una Funcion 