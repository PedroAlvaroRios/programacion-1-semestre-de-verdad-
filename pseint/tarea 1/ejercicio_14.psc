Algoritmo ejercicio_14
	Escribir "a continuacion ingrese 2 numeros: "
	Leer numero_1, numero_2
	
	Escribir "ingrese que tipo de numero busca en estos con una letra (p: pares i: impares): "
	Leer buscar
	
	numero_proceso=0
	
	buscar = Minusculas(buscar)
	
	Si buscar="p" Entonces		
		Para numero_proceso=numero_1 Hasta numero_2 Hacer
			si numero_proceso%2=0 Entonces
				Escribir numero_proceso
			FinSi
		Fin Para
	SiNo
		si buscar="i"
			Para numero_proceso=numero_1 Hasta numero_2 Hacer
				si numero_proceso%2<>1 Entonces
					Escribir numero_proceso
				FinSi
			Fin Para
		SiNo
			Escribir "letra no valida"
		FinSi
	FinSi
	
	Escribir "la siguiente cadena de numeros que cumplen con lo indicado que estan entre ", numero_1," y ", numero_2 ," es:"
	
	Escribir "tarea completada"
	
FinAlgoritmo

//usar la Funcion PARA te puede ayudar a hacer loops que se repitan hasta que te llegue a cierto numero